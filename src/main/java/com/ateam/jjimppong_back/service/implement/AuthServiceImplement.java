package com.ateam.jjimppong_back.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ateam.jjimppong_back.common.dto.request.auth.EmailAuthCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.request.auth.EmailAuthRequestDto;
import com.ateam.jjimppong_back.common.dto.request.auth.IdCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.request.auth.NicknameCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.request.auth.SignUpRequestDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;
import com.ateam.jjimppong_back.common.entity.EmailAuthEntity;
import com.ateam.jjimppong_back.common.entity.UserEntity;
import com.ateam.jjimppong_back.common.util.EmailAuthNumberUtil;
import com.ateam.jjimppong_back.repository.EmailAuthNumberRepository;
import com.ateam.jjimppong_back.repository.UserRepository;
import com.ateam.jjimppong_back.service.AuthService;

import jakarta.mail.MessagingException;

import com.ateam.jjimppong_back.provider.JwtProvider;
import com.ateam.jjimppong_back.provider.MailProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

    // 중복 확인
    private final UserRepository userRepository;
    // 이메일, 인증번호 확인
    private final EmailAuthNumberRepository emailAuthNumberRepository;
    // 메일 전송
    private final MailProvider mailProvider;
    // // Jwt키 생성 및 검증
    // private final JwtProvider jwtProvider;
    // 비밀번호 암호화
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {

        try{
          
          String userId = dto.getUserId();
          boolean existUser = userRepository.existsByUserId(userId);
          if(existUser) return ResponseDto.existUser();

        } catch(Exception exception){ 
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> nicknameCheck(NicknameCheckRequestDto dto) {

        try{
            String userNickname = dto.getUserNickname();
            boolean existNickname = userRepository.existsByUserNickname(userNickname);
            if(existNickname) return ResponseDto.existUser();
  
          } catch(Exception exception){ 
              exception.printStackTrace();
              return ResponseDto.databaseError();
          }

        return ResponseDto.success(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> emailAuth(EmailAuthRequestDto dto) {

        try{

            String userEmail = dto.getUserEmail();

            boolean existEmail = userRepository.existsByUserEmail(userEmail);
            // 이메일 중복 에러 코드 전송
            if(existEmail) return ResponseDto.duplicatiedEmail();

            // 생성한 인증번호 를 authNumber에 저장
            String authNumber = EmailAuthNumberUtil.createCodeNumber();

            EmailAuthEntity emailAuthEntity = new EmailAuthEntity(userEmail, authNumber);
            // 저장소에 이메일과, 인증번호 저장
            emailAuthNumberRepository.save(emailAuthEntity);

            // 메일 전송 기능 사용
            mailProvider.mailAuthSend(userEmail, authNumber);
  
          } catch(MessagingException exception){ 
            exception.printStackTrace();
            return ResponseDto.mailSendFail();
          } catch(Exception exception){ 
              exception.printStackTrace();
              return ResponseDto.databaseError();
          }

        return ResponseDto.success(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ResponseDto> emailAuthCheck(EmailAuthCheckRequestDto dto) {

        try { 

            String userEmail = dto.getUserEmail();
            String authNumber = dto.getAuthNumber();

            // 이메일과 인증번호 확인
            boolean isMatched = emailAuthNumberRepository.existsByUserEmailAndAuthNumber(userEmail, authNumber);
            // 만일 이메일과 인증번호가 일치하지 않는다면 'AF' 인증실패
            if (!isMatched) return ResponseDto.authFail();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {
        
        try{

            String userId = dto.getUserId();
            boolean existUser = userRepository.existsByUserId(userId);
            if(existUser) return ResponseDto.existUser();

            String userNickname = dto.getUserNickname();
            boolean existNickname = userRepository.existsByUserNickname(userNickname);
            if(existNickname) return ResponseDto.existUser();

            String userEmail = dto.getUserEmail();
            boolean existEmail = userRepository.existsByUserEmail(userEmail);
            if(existEmail) return ResponseDto.existUser();

            String userPassword = dto.getUserPassword();
            // 암호화한 비밀번호
            String encodedPassword = passwordEncoder.encode(userPassword);
            dto.setUserPassword(encodedPassword);
            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch (Exception exception){ 
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success(HttpStatus.CREATED);

    }

}
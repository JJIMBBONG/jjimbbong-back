package com.ateam.jjimppong_back.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ateam.jjimppong_back.common.dto.request.auth.EmailCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.request.auth.IdCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.request.auth.NicknameCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;
import com.ateam.jjimppong_back.repository.UserRepository;
import com.ateam.jjimppong_back.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

    private final UserRepository userRepository;

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
    public ResponseEntity<ResponseDto> emailCheck(EmailCheckRequestDto dto) {

        try{
            String userEmail = dto.getUserEmail();
            boolean existEmail = userRepository.existsByUserNickname(userEmail);
            if(existEmail) return ResponseDto.existUser();
  
        } catch(Exception exception){ 
              exception.printStackTrace();
              return ResponseDto.databaseError();
        }


        return ResponseDto.success(HttpStatus.OK);
    }

}

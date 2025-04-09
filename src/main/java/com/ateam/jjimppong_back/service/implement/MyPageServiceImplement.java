package com.ateam.jjimppong_back.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ateam.jjimppong_back.common.dto.request.mypage.PasswordReCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;
import com.ateam.jjimppong_back.common.dto.response.mypage.GetSignInUserResponseDto;
import com.ateam.jjimppong_back.common.entity.UserEntity;
import com.ateam.jjimppong_back.repository.MyPageRepository;
import com.ateam.jjimppong_back.repository.UserRepository;
import com.ateam.jjimppong_back.service.MyPageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageServiceImplement implements MyPageService {

  private final MyPageRepository myPageRepository;
  private final UserRepository userRepository;
  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public ResponseEntity<ResponseDto> passwordReCheck(PasswordReCheckRequestDto dto, String userId) {
    
    try {

      UserEntity userEntity = userRepository.findByUserId(userId);

      String inputPassword = dto.getUserPassword();
      String encodedPassword = userEntity.getUserPassword();
      boolean isMatch = passwordEncoder.matches(inputPassword, encodedPassword);
      if (!isMatch) return ResponseDto.passwordNotMatched();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId) {
    
    UserEntity userEntity = null;

    try {

      userEntity = userRepository.findByUserId(userId);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetSignInUserResponseDto.success(userEntity);
  }
  
}

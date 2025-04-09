package com.ateam.jjimppong_back.service;

import org.springframework.http.ResponseEntity;

import com.ateam.jjimppong_back.common.dto.request.PasswordReCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.response.GetSignInUserResponseDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;

public interface MyPageService {
  ResponseEntity<ResponseDto> passwordReCheck(PasswordReCheckRequestDto dto, String userId);
  ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId);
}

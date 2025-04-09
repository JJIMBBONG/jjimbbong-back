package com.ateam.jjimppong_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.jjimppong_back.common.dto.request.PasswordReCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.response.GetSignInUserResponseDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;
import com.ateam.jjimppong_back.service.MyPageService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/my-page")
@RequiredArgsConstructor
public class MyPageController {

  private final MyPageService myPageService;

  @PostMapping({"", "/"})
  public ResponseEntity<ResponseDto> passwordReCheck(
    @RequestBody @Valid PasswordReCheckRequestDto requestBody,
    @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<ResponseDto> response = myPageService.passwordReCheck(requestBody, userId);
    return response;
  }

  @GetMapping("/user-info")
  public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
    @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<? super GetSignInUserResponseDto> response = myPageService.getSignInUser(userId);
    return response;
  }
  
}

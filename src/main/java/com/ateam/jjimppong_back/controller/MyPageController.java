package com.ateam.jjimppong_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.jjimppong_back.common.dto.request.mypage.PasswordReCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.request.mypage.PatchSignInUserRequestDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;
import com.ateam.jjimppong_back.common.dto.response.mypage.GetMyPageBoardResponseDto;
import com.ateam.jjimppong_back.common.dto.response.mypage.GetSignInUserResponseDto;
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

  @GetMapping({"", "/"})
  public ResponseEntity<? super GetMyPageBoardResponseDto> getMyPageBoard(
    @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<? super GetMyPageBoardResponseDto> response = myPageService.getMyPageBoard(userId);
    return response;
  }

  @GetMapping({"", "/"})
  public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
    @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<? super GetSignInUserResponseDto> response = myPageService.getSignInUser(userId);
    return response;
  }

  @PatchMapping({"", "/"})
  public ResponseEntity<ResponseDto> patchSignInUser(
    @RequestBody @Valid PatchSignInUserRequestDto requestBody,
    @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<ResponseDto> response = myPageService.patchSignInUser(requestBody, userId);
    return response;
  }
  
}

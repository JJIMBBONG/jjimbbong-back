package com.ateam.jjimppong_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.jjimppong_back.common.dto.request.auth.EmailAuthRequestDto;
import com.ateam.jjimppong_back.common.dto.request.auth.IdCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.request.auth.NicknameCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;
import com.ateam.jjimppong_back.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/id-check")
    public ResponseEntity<ResponseDto> idCheck(
        @RequestBody @Valid IdCheckRequestDto requestBody
    ){ 
        ResponseEntity<ResponseDto> response = authService.idCheck(requestBody);
        return response;
    }

    @PostMapping("/nickname-check")
    public ResponseEntity<ResponseDto> nicknameCheck(
        @RequestBody @Valid NicknameCheckRequestDto requestBody
    ){ 
        ResponseEntity<ResponseDto> response = authService.nicknameCheck(requestBody);
        return response;
    }

    @PostMapping("/email-auth")
    public ResponseEntity<ResponseDto> emailAuth( 
        @RequestBody @Valid EmailAuthRequestDto requestBody
    ){ 
        ResponseEntity<ResponseDto> response = authService.emailAuth(requestBody);
        return response;
    }
    
}

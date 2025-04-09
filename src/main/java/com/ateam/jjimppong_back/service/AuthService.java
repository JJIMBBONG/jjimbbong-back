package com.ateam.jjimppong_back.service;

import org.springframework.http.ResponseEntity;

import com.ateam.jjimppong_back.common.dto.request.auth.EmailAuthRequestDto;
import com.ateam.jjimppong_back.common.dto.request.auth.IdCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.request.auth.NicknameCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;

public interface AuthService {

    ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<ResponseDto> nicknameCheck(NicknameCheckRequestDto dto);
    ResponseEntity<ResponseDto> emailAuth(EmailAuthRequestDto dto);
}

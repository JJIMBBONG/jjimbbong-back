package com.ateam.jjimppong_back.service;

import org.springframework.http.ResponseEntity;

import com.ateam.jjimppong_back.common.dto.request.auth.IdCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;

public interface AuthService {
    ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
}

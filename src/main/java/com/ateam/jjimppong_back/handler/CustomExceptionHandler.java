package com.ateam.jjimppong_back.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ateam.jjimppong_back.common.dto.response.ResponseDto;

// 예외 발생시 응답처리
@RestControllerAdvice
public class CustomExceptionHandler {
    
        // description: MethodArgumentNotValidException - 유효성 검사 실패시 예외
    // description: HttpMessageNotReadableException- RequestBody가 필요한데 존재하지 않을때
    @ExceptionHandler({
        MethodArgumentNotValidException.class,
        HttpMessageNotReadableException.class
    })
    public ResponseEntity<ResponseDto> validExceptionHandler(Exception exception){
        exception.printStackTrace();
        return ResponseDto.validationFail();
    }
}

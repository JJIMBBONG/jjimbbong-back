package com.ateam.jjimppong_back.common.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PasswordReCheckRequestDto {
  @NotBlank
  private String userPassword;
}

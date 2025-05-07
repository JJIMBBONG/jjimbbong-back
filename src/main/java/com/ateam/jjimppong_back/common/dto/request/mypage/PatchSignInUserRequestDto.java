package com.ateam.jjimppong_back.common.dto.request.mypage;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchSignInUserRequestDto {
  @NotBlank
  private String userNickname;
  private String userPassword;
  @NotBlank
  private String address;
  private String detailAddress;
  private String profileImage;
}

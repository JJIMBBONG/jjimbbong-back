package com.ateam.jjimppong_back.common.dto.request.mypage;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PostMyPageInfoRequestDto {
  @NotNull
  @Min(0)
  private Integer userLevel;
  @NotNull
  @Min(0)
  private Integer userScore;
}

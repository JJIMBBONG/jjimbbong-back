package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyPageEntity {
  @Id
  private String userId;
  private String userNickname;
  private Integer boardNumber;
  private Integer userLevel;
  private Integer userScore;
}

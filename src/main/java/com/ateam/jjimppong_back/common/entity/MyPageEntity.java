package com.ateam.jjimppong_back.common.entity;

import com.ateam.jjimppong_back.common.dto.request.mypage.PostMyPageInfoRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "myPage")
@Table(name = "my_page")
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

  public MyPageEntity(PostMyPageInfoRequestDto dto, String userId, String userNickname) {
    this.userId = userId;
    this.userNickname = userNickname;
    this.userLevel = dto.getUserLevel();
    this.userScore = dto.getUserScore();
  }

  public MyPageEntity(PostMyPageInfoRequestDto dto, MyPageEntity preEntity, String userId) {
    this.userId = userId;
    this.userScore = preEntity.getUserScore() + dto.getUserScore();
  }
}

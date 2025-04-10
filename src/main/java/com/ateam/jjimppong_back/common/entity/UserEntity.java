package com.ateam.jjimppong_back.common.entity;

import com.ateam.jjimppong_back.common.dto.request.mypage.PatchSignInUserRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
  @Id
  private String userId;
  private String userNickname;
  private String userPassword;
  private String userEmail;
  private String joinType;
  private String name;
  private String address;
  private String detailAddress;
  private Integer userLevel;
  private String gender;
  private String profileImage;
  private String snsId;

  public void patch(PatchSignInUserRequestDto dto) {
    this.userNickname = dto.getUserNickname();
    this.userPassword = dto.getUserPassword();
    this.address = dto.getAddress();
    this.detailAddress = dto.getDetailAddress();
  }
}

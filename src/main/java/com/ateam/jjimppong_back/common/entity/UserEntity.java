package com.ateam.jjimppong_back.common.entity;

import com.ateam.jjimppong_back.common.dto.request.auth.SignUpRequestDto;

import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_nickname")
    private String userNickname;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "join_type")
    private String joinType;

    private String name;
    private String address;

    @Column(name = "detail_address")
    private String detailAddress;

    @Column(name = "user_level")
    private Integer userLevel;

    private String gender;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "sns_id")
    private String snsId;

    public UserEntity(SignUpRequestDto dto){ 
        this.userId = dto.getUserId();
        this.userNickname = dto.getUserNickname();
        this.userEmail = dto.getUserEmail();
        this.name = dto.getName();
        this.userPassword = dto.getUserPassword();
        this.address = dto.getAddress();
        this.detailAddress = dto.getDetailAddress();
        this.profileImage = dto.getProfileImage();
        this.gender = dto.getGender();
        this.userLevel = Integer.parseInt(dto.getUserLevel());
        this.joinType = dto.getJoinType();

    }

}

package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "snsUser")
@Table(name = "sns_user")  // sns_user 테이블과 매핑
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SnsUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long autoId;

    private String snsId;
    private String joinType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)  // 외래 키 설정
    private UserEntity userEntity;  // UserEntity와의 관계

    // 생성자에서 필드 설정
    public SnsUserEntity(String snsId, String joinType, UserEntity userEntity) {
        this.snsId = snsId;
        this.joinType = joinType;
        this.userEntity = userEntity;  // userEntity로 설정
    }

    // 새로운 생성자 추가
    public SnsUserEntity(String snsId, String joinType) {
        this.snsId = snsId;
        this.joinType = joinType;
    }
}
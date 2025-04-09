package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
public class MyPageEntity {
    
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_nickname")
    private String userNickname;

    @Column(name = "user_number")
    private Integer boardNumber;

    @Column(name = "user_level")
    private Integer userLevel;

    @Column(name = "user_score")
    private Integer userScore;

}

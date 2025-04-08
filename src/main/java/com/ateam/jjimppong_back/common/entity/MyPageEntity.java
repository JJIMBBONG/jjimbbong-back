package com.ateam.jjimppong_back.common.entity;

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
    private String userId;
    private String userNickname;
    private Integer boardNumber;
    private Integer userLevel;
    private Integer userScore;

}

package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "comment")
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_number")
    private Integer commentNumber;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "board_number")
    private Integer boardNumber;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "user_level")
    private Integer userLevel;

    @Column(name = "write_date")
    private String writeDate;
}
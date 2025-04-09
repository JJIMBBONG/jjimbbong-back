package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "board")
@Table(name = "board")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity {
    
    @Id
    @Column(name = "board_number")
    private Integer boardNumber;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_nickname")
    private String userNickname;

    @Column(name = "user_level")
    private Integer userLevel;

    @Column(name = "board_content")
    private String boardContent;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name = "board_address_category")
    private String boardAddressCategory;

    @Column(name = "board_dtail_category")
    private String boardDetailCatagory;

    @Column(name = "board_write_date")
    private String boardWriteDate;

    @Column(name = "board_view_count")
    private Integer boardViewCount;

    @Column(name = "board_score")
    private Integer boardScore;

    @Column(name = "board_address")
    private String boardAddress;

    @Column(name = "board_image")
    private String boardImage;

}


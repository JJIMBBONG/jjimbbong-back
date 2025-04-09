package com.ateam.jjimppong_back.common.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.ateam.jjimppong_back.common.dto.request.board.PatchBoardRequestDto;
import com.ateam.jjimppong_back.common.dto.request.board.PostBoardRequestDto;

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
    private Integer boardNumber;
    private String userId;
    private String userNickname;
    private Integer userLevel;
    private String boardContent;
    private String boardTitle;
    private String boardAddressCategory;
    private String boardDetailCategory;
    private String boardWriteDate;
    private Integer boardViewCount;
    private Integer boardScore;
    private String boardAddress;
    private String boardImage;

    public BoardEntity(PostBoardRequestDto dto, String userNickname) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter DateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-DD")
        this.userId = userId;
        this.userNickname = userNickname;
        this.boardContent = dto.getBoardContent();
        this.boardTitle = dto.getBoardTitle();
        this.boardAddressCategory = dto.getBoardAddressCategory();
        this.boardDetailCategory = dto.getBoardDetailCategory();
        this.boardWriteDate = LocalDate.now();
        this.boardViewCount = 0;
        this.boardScore = 0;
        this.boardAddress = dto.getBoardAddress();
        this.boardImage = dto.getBoardImage();
    }
    

    public void patch(PatchBoardRequestDto dto) {
        this.boardAddressCategory = dto.getBoardAddressCategory();
        this.boardDetailCategory = dto.getBoardDetailCategory();
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
    }
}

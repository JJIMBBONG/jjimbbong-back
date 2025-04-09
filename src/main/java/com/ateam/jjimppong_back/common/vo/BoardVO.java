package com.ateam.jjimppong_back.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.ateam.jjimppong_back.common.entity.BoardEntity;

import lombok.Getter;

@Getter
public class BoardVO {
  private Integer boardNumber;
  private String boardWriteDate;
  private String boardAddressCategory;
  private List<String> boardDetailCategory;
  private String boardTitle;
  private String boardContent;
  private String boardAddress;
  private Integer boardViewCount;
  private Integer boardScore;
  private String boardImage;

  private BoardVO(BoardEntity boardEntity) {
    this.boardNumber = boardEntity.getBoardNumber();
    this.boardWriteDate = boardEntity.getBoardWriteDate();
    this.boardAddressCategory = boardEntity.getBoardAddressCategory();
    this.boardTitle = boardEntity.getBoardTitle();
    this.boardContent = boardEntity.getBoardContent();
    this.boardAddress = boardEntity.getBoardAddress();
    this.boardViewCount = boardEntity.getBoardViewCount();
    this.boardImage = boardEntity.getBoardImage();
  }

  public static List<BoardVO> getList(List<BoardEntity> boardEntities) {

    List<BoardVO> list = new ArrayList<>();
    for (BoardEntity boardEntity: boardEntities) {
      BoardVO vo = new BoardVO(boardEntity);
      list.add(vo);
    }

    return list;
  }
}

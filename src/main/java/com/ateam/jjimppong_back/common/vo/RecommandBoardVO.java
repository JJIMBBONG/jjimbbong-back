package com.ateam.jjimppong_back.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.ateam.jjimppong_back.common.entity.BoardEntity;

import lombok.Getter;

@Getter
public class RecommandBoardVO {
    private String boardWriteDate;
    private String boardAddressCategory;
    private String boardDetailCategory;
    private String boardTitle;
    private Integer boardViewCount;
    private Integer boardScore;
    private String boardImage;

    private RecommandBoardVO(BoardEntity boardEntity) {
    this.boardWriteDate = boardEntity.getBoardWriteDate();
    this.boardAddressCategory = boardEntity.getBoardAddressCategory();
    this.boardDetailCategory = boardEntity.getBoardDetailCategory();
    this.boardTitle = boardEntity.getBoardTitle();
    this.boardViewCount = boardEntity.getBoardViewCount();
    this.boardScore = boardViewCount;
    this.boardImage = boardEntity.getBoardImage();
  }

  public static List<RecommandBoardVO> getList(List<BoardEntity> boardEntities) {

    List<RecommandBoardVO> list = new ArrayList<>();
    for (BoardEntity boardEntity: boardEntities) {
        RecommandBoardVO vo = new RecommandBoardVO(boardEntity);
        list.add(vo);
    }

    return list;
  }
}

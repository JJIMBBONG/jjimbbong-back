package com.ateam.jjimppong_back.common.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ateam.jjimppong_back.common.dto.response.ResponseDto;
import com.ateam.jjimppong_back.common.entity.BoardEntity;
import com.ateam.jjimppong_back.common.vo.BoardVO;

public class GetMyBoardResponseDto extends ResponseDto {

  private List<BoardVO> boards;

  private GetMyBoardResponseDto(List<BoardEntity> boardEntities) {
    this.boards = BoardVO.getList(boardEntities);
  }

  public static ResponseEntity<GetMyBoardResponseDto> success (List<BoardEntity> boardEntities) {
    GetMyBoardResponseDto body = new GetMyBoardResponseDto(boardEntities);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
  
}

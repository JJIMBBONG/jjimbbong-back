package com.ateam.jjimppong_back.common.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ateam.jjimppong_back.common.dto.response.ResponseDto;
import com.ateam.jjimppong_back.common.entity.BoardEntity;
import com.ateam.jjimppong_back.common.vo.RecommandBoardVO;

import lombok.Getter;

@Getter
public class GetRecommandBoardResponseDto extends ResponseDto{

  private List<RecommandBoardVO> boards;

  private GetRecommandBoardResponseDto(List<BoardEntity> boardEntities) {
    this.boards = RecommandBoardVO.getList(boardEntities);
  }

  public static ResponseEntity<GetRecommandBoardResponseDto> success(List<BoardEntity> boardEntities) {
    GetRecommandBoardResponseDto body = new GetRecommandBoardResponseDto(boardEntities);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
    
}

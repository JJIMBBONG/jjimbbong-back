package com.ateam.jjimppong_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ateam.jjimppong_back.common.dto.request.board.PatchBoardRequestDto;
import com.ateam.jjimppong_back.common.dto.request.board.PostBoardRequestDto;
import com.ateam.jjimppong_back.common.dto.request.board.PostCommentRequestDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;
import com.ateam.jjimppong_back.common.dto.response.board.GetBoardResponseDto;
import com.ateam.jjimppong_back.common.dto.response.board.GetCommentResponseDto;
import com.ateam.jjimppong_back.common.dto.response.board.GetMyBoardResponseDto;
import com.ateam.jjimppong_back.common.dto.response.board.GetRecommandBoardResponseDto;
import com.ateam.jjimppong_back.common.entity.BoardEntity;
import com.ateam.jjimppong_back.common.entity.CommentEntity;
import com.ateam.jjimppong_back.repository.BoardRepository;
import com.ateam.jjimppong_back.repository.CommentRepository;
import com.ateam.jjimppong_back.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

  private final BoardRepository boardRepository;
  private final CommentRepository commentRepository; 

  @Override
  public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto, String userId, String userNickname) {
    
    try {

      BoardEntity boardEntity = new BoardEntity(dto, userId, userNickname);
      boardRepository.save(boardEntity);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);
    
  }

  @Override
  public ResponseEntity<? super GetMyBoardResponseDto> getMyBoard(String userId) {
    
    List<BoardEntity> boardEntities;

    try {

      boardEntities = boardRepository.findByUserIdOrderByBoardNumberDesc(userId);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetMyBoardResponseDto.success(boardEntities);
    
  }

  @Override
  public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {
    
    BoardEntity boardEntity = null;

    try {

      boardEntity = boardRepository.findByBoardNumber(boardNumber);
      if (boardEntity == null) return ResponseDto.noExistBoard();
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetBoardResponseDto.success(boardEntity);

  }

  // 추천 게시물 목록 가져오기 //
  @Override
  public ResponseEntity<? super GetRecommandBoardResponseDto> getRecommandBoard() {
    List<BoardEntity> boardEntities = new ArrayList<>();

    try {

      boardEntities = boardRepository.findByOrderByBoardScoreDesc();
      if( boardEntities == null ) return ResponseDto.noExistBoard();

    } catch(Exception exception){
      exception.printStackTrace();;
      return ResponseDto.databaseError();
    }

    return GetRecommandBoardResponseDto.success(boardEntities);
  }

  @Override
  public ResponseEntity<ResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber, String userId) {
    
    try {

      BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
      if (boardEntity == null) return ResponseDto.noExistBoard();

      String boardWriterID = boardEntity.getUserId();
      boolean isWriter = boardWriterID.equals(userId);
      if (!isWriter) return ResponseDto.noPermission();

      boardEntity.patch(dto);
      boardRepository.save(boardEntity);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.OK);

  }

  @Override
  public ResponseEntity<ResponseDto> deleteBoard(Integer boardNumber, String userId) {

    try {

      BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
      if (boardEntity == null) return ResponseDto.noExistBoard();

      String boardWriterId = boardEntity.getUserId();
      boolean isWriter = boardWriterId.equals(userId);
      if (!isWriter) return ResponseDto.noPermission();

      boardRepository.delete(boardEntity);
      return ResponseDto.success(HttpStatus.NO_CONTENT);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
  }

  @Override
  public ResponseEntity<? super GetCommentResponseDto> getComment(Integer boardNumber) {
    
    List<CommentEntity> commentEntities = new ArrayList<>();

    try {

      commentEntities = commentRepository.findByBoardNumberOrderByWriteDateDesc(boardNumber);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetCommentResponseDto.success(commentEntities);

  }

  @Override
  public ResponseEntity<ResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String userId) {
    
    try {

      boolean existBoard = boardRepository.existsByBoardNumber(boardNumber);
      if (!existBoard) return ResponseDto.noExistBoard();

      CommentEntity commentEntity = new CommentEntity(dto, boardNumber, userId);
      commentRepository.save(commentEntity);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);

  }
  
}

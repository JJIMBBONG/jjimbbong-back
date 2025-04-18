package com.ateam.jjimppong_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ateam.jjimppong_back.common.entity.BoardEntity;
import com.ateam.jjimppong_back.common.vo.BoardProjection;
import com.ateam.jjimppong_back.common.vo.RecommandBoardProjection;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Integer>{
  
  boolean existsByBoardNumber(Integer boardNumber);
  BoardEntity findByBoardNumber(Integer boardNumber);

  List<BoardEntity> findByUserIdOrderByBoardWriteDateDescBoardNumberDesc(String UserId);
  List<BoardEntity> findByOrderByBoardScoreDesc();

  // boardScore 합계
  @Query(value = 
    "SELECT COALESCE(SUM(board_score), 0) " +
    "FROM board " +
    "WHERE user_id = :userId ",
    nativeQuery = true)
    Integer sumBoardScoreByUserId(String userId);

  @Query(value = 
    "SELECT b.board_number AS boardNumber, " +
    "       b.board_content AS boardContent, " +
    "       b.board_title AS boardTitle, " +
    "       b.board_address_category AS boardAddressCategory, " +
    "       b.board_detail_category AS boardDetailCategory, " +
    "       b.board_write_date AS boardWriteDate, " +
    "       b.board_view_count AS boardViewCount, " +
    "       b.board_score AS boardScore, " +
    "       b.board_address AS boardAddress, " +
    "       b.board_image AS boardImage, " +
    "       u.user_id AS userId, " +
    "       u.user_nickname AS userNickname, " +
    "       u.user_level AS userLevel " +
    "FROM board b " +
    "LEFT JOIN user u ON b.user_id = u.user_id " +
    "ORDER BY b.board_number DESC",
    nativeQuery = true)
    List<BoardProjection> findByUserIdOrderByBoardNumberDesc(String userId);

  @Query(value =
        "SELECT b.board_number As boardNumber, " +
        "       b.board_write_date AS boardWriteDate, " +
        "       b.board_address_category AS boardAddressCategory, " +
        "       b.board_detail_category AS boardDetailCategory, " +
        "       b.board_title AS boardTitle, " +
        "       b.board_view_count AS boardViewCount, " +
        "       b.board_score AS boardScore, " +
        "       b.board_image AS boardImage, " +
        "       b.user_nickname AS userNickname, " +
        "       COUNT(g.board_number) AS likeCount " +
        "FROM board b " +
        "LEFT JOIN good g ON b.board_number = g.board_number " +
        "GROUP BY b.board_number " +
        "ORDER BY b.board_score DESC",
        nativeQuery = true)
    List<RecommandBoardProjection> findAllWithLikeCount();





}
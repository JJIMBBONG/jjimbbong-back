package com.ateam.jjimppong_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ateam.jjimppong_back.common.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Integer>{
  
  boolean existsByBoardNumber(Integer boardNumber);

  BoardEntity findByBoardNumber(Integer boardNumber);

  List<BoardEntity> findByUserIdOrderByBoardWriteDateDesc(String UserId);

}
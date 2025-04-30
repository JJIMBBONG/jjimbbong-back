package com.ateam.jjimppong_back.common.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.ateam.jjimppong_back.common.dto.request.board.PostCommentRequestDto;

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
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer commentNumber;
  private Integer boardNumber;
  private String commentContent;
  @Column(name = "user_id")
  private String commentWriterId;
  @Column(name = "write_date")
  private String commentWriteDate;
  private Integer userLevel;

  public CommentEntity(PostCommentRequestDto dto, Integer boardNumber, String userId, Integer userLevel) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    this.boardNumber = boardNumber;
    this.commentWriterId = userId;
    this.userLevel = userLevel;
    this.commentWriteDate = now.format(dateTimeFormatter);
    this.commentContent = dto.getCommentContent();
  }
}
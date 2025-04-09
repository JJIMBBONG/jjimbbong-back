package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}

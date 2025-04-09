package com.ateam.jjimppong_back.common.dto.request.board;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatchBoardRequestDto {
  @NotNull
  private Integer boardNumber;
  @NotBlank
  private String boardAddressCategory;
  @NotNull
  private List<String> boardDetailCategory;
  @NotBlank
  private String boardTitle;
  @NotBlank
  private String boardContent;
  private String boardAddress;
  @NotBlank
  @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
  private String boardWriteDate;
  @NotNull
  private Integer boardViewCount;
  @NotNull
  private Integer boardScore;
  private String boardImage;
}

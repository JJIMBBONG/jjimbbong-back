package com.ateam.jjimppong_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ateam.jjimppong_back.common.dto.request.mypage.PasswordReCheckRequestDto;
import com.ateam.jjimppong_back.common.dto.request.mypage.PatchSignInUserRequestDto;
import com.ateam.jjimppong_back.common.dto.request.mypage.PostMyPageInfoRequestDto;
import com.ateam.jjimppong_back.common.dto.response.ResponseDto;
import com.ateam.jjimppong_back.common.dto.response.mypage.GetMyPageBoardResponseDto;
import com.ateam.jjimppong_back.common.dto.response.mypage.GetSignInUserResponseDto;
import com.ateam.jjimppong_back.common.entity.BoardEntity;
import com.ateam.jjimppong_back.common.entity.MyPageEntity;
import com.ateam.jjimppong_back.common.entity.UserEntity;
import com.ateam.jjimppong_back.repository.BoardRepository;
import com.ateam.jjimppong_back.repository.MyPageRepository;
import com.ateam.jjimppong_back.repository.UserRepository;
import com.ateam.jjimppong_back.service.MyPageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageServiceImplement implements MyPageService {

  private final UserRepository userRepository;
  private final BoardRepository boardRepository;
  private final MyPageRepository myPageRepository;
  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  
  @Override
  public ResponseEntity<ResponseDto> passwordReCheck(PasswordReCheckRequestDto dto, String userId) {
    
    try {
      UserEntity userEntity = userRepository.findByUserId(userId);
      String inputPassword = dto.getUserPassword();
      String encodedPassword = userEntity.getUserPassword();
      boolean isMatch = passwordEncoder.matches(inputPassword, encodedPassword);
      if (!isMatch) return ResponseDto.passwordNotMatched();
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ResponseDto> postMyPageInfo(PostMyPageInfoRequestDto dto, String userId, Integer boardNumber) {
    
    try {
      MyPageEntity myPageEntity = null;

      boolean isExistBoard = boardRepository.existsByBoardNumber(boardNumber);
      if (!isExistBoard) return ResponseDto.noExistBoard();

      BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
      String writerId = boardEntity.getUserId();
      boolean isEquals = userId.equals(writerId);
      if (!isEquals) return ResponseDto.authFail();

      UserEntity userEntity = userRepository.findByUserId(userId);
      Integer userLevel = userEntity.getUserLevel();
      String userNickname = userEntity.getUserNickname();

      Integer count = myPageRepository.countByUserId(userId);
      if (count == 0) {
        myPageEntity = new MyPageEntity(userId, userNickname, userLevel, boardNumber, dto);
      } else {
        MyPageEntity preMyPageEntity = myPageRepository.findByUserId(userId);
        myPageEntity = new MyPageEntity(dto, preMyPageEntity, userNickname, userId, boardNumber, userLevel);
      }
      myPageRepository.save(myPageEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success(HttpStatus.OK);
  }
  
  @Override
  public ResponseEntity<? super GetMyPageBoardResponseDto> getMyPageBoard(String userId) {
    List<BoardEntity> boardEntities = new ArrayList<>();

    try {
      boardEntities = boardRepository.findByUserIdOrderByBoardWriteDateDesc(userId);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return GetMyPageBoardResponseDto.success(boardEntities);
  }

  @Override
  public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId) {
    UserEntity userEntity = null;

    try {
      userEntity = userRepository.findByUserId(userId);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return GetSignInUserResponseDto.success(userEntity);
  }

  @Override
  public ResponseEntity<ResponseDto> patchSignInUser(PatchSignInUserRequestDto dto, String userId) {
    
    try {
      UserEntity userEntity = userRepository.findByUserId(userId);

      String userNickname = dto.getUserNickname();
      boolean isExist = userRepository.existsByUserNickname(userNickname);
      if (isExist) return ResponseDto.existUser();

      userEntity.patch(dto);
      userRepository.save(userEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success(HttpStatus.OK);
  }


}

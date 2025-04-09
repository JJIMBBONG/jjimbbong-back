package com.ateam.jjimppong_back.common.dto.response;

public interface ResponseMessage {
  String SUCCESS = "Success.";

  String VALIDATION_FAIL = "Validation Fail.";
  String EXIT_USER = "Exist User.";
  String NO_EXIST_BOARD = "No Exist Board.";

  String SIGN_IN_FAIL = "Sign in Fail.";

  String NO_PERMISSION = "No Permission.";

  String DATABASE_ERROR = "Database Error.";
}

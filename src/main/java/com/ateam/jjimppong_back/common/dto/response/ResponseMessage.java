package com.ateam.jjimppong_back.common.dto.response;

public interface ResponseMessage {
  String SUCCESS = "Success.";

  String VALIDATION_FAIL = "Validation Fail.";

  String EXIST_USER = "Exist User.";
  String DUPLICATED_EMAIL = "Duplicated Email";
  String NO_EXIST_BOARD = "No Exist Board.";
  String PASSWORD_NOT_MATCHED = "Password Not Matched";
  
  String SIGN_IN_FAIL = "Sign in Fail.";
  String NO_PERMISSION = "No Permission.";

  String MAIL_SEND_FAILED = "Mail send Failed";
  String DATABASE_ERROR = "Database Error";

}

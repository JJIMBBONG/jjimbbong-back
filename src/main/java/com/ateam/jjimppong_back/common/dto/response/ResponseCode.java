package com.ateam.jjimppong_back.common.dto.response;

public interface ResponseCode {
  String SUCCESS = "SU";

  String VALIDATION_FAIL = "VF";
  String EXIST_USER = "EU";
  String DUPLICATED_EMAIL = "DE";
  String NO_EXIST_BOARD = "NB";
  String PASSWORD_NOT_MATCHED = "PN";
  
  String SIGN_IN_FAIL = "SF";
  String NO_PERMISSION = "NP";

  String MAIL_SEND_FAILED = "MF";

  String DATABASE_ERROR = "DBE";
}

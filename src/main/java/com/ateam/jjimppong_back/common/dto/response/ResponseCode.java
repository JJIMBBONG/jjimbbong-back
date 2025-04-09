package com.ateam.jjimppong_back.common.dto.response;

public interface ResponseCode {
  String SUCCESS = "SU";

  String VALIDATION_FAIL = "VF";
  String EXIT_USER = "EU";
  String NO_EXIST_BOARD = "NB";

  String SIGN_IN_FAIL = "SF";

  String NO_PERMISSION = "NP";

  String DATABASE_ERROR = "DBE";
}

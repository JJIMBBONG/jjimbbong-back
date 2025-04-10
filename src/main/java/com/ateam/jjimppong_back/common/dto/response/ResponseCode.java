package com.ateam.jjimppong_back.common.dto.response;

public interface ResponseCode {
    String SUCCESS = "SU";
    String VALIDATION_FAIL = "VF";
    String SIGN_IN_FAIL = "SF";
    String EXIST_USER = "EU";
    String DATABASE_ERROR  = "DBE";
    String DUPLICATIED_EMAIL = "DE";
    String MAIL_SEND_FAIL = "MF";
    String AUTH_FAIL = "AF";
}

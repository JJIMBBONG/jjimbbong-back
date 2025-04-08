package com.ateam.jjimppong_back.common.dto.response;

public interface ResponseMessage {
    String SUCCESS = "Success.";
    String VALIDATION_FAIL = "Validation Fail.";
    String SIGN_IN_FAIL = "Sign in Fail";
    String EXIST_USER = "Exist User.";
    String DATABASE_ERROR  = "Database Error.";
    String DUPLICATIED_EMAIL = "Duplicatied Email";
    String MAIL_FAIL = "Mail Fail";
    String AUTH_FAIL = "Auth Fail";
}

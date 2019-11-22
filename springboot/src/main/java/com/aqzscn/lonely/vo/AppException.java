package com.aqzscn.lonely.vo;

public class AppException extends Exception {

    private int errorCode = GlobalNames.unknownError;

    private AppException() {
        super();
    }

    private AppException(String message) {
        super(message);
    }

    public static AppException of() {
        return new AppException("发生未知错误");
    }

    public static AppException of(String message) {
        return new AppException(message);
    }

    public static AppException of(int code) {
        AppException ae = new AppException();
        ae.errorCode = code;
        return ae;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

}

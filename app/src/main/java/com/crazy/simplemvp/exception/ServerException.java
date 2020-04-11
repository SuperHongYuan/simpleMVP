package com.crazy.simplemvp.exception;


public class ServerException extends Exception {
    public ServerException(String message) {
        super(message);
    }
    public ServerException() {
        super("服务器地址异常");
    }
}

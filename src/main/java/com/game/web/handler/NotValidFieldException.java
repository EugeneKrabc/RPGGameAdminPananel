package com.game.web.handler;

public class NotValidFieldException extends RuntimeException {
    public NotValidFieldException(String message) {
        super(message);
    }
}

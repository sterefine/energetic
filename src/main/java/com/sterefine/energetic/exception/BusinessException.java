package com.sterefine.energetic.exception;

import lombok.ToString;

@ToString
public class BusinessException extends RuntimeException{
    int code;

    BusinessException(int code, String message ) {
        super(message);
        this.code = code;
    }

    BusinessException(String message ) {
        this(-1, message);
    }

    BusinessException() {
        super();
    }
}

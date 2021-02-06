package com.sterefine.energetic.exception;

import lombok.ToString;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

@ToString
public class ApiException extends RuntimeException{
    private int code;
    private Object[] args;
    private ResultCode resultCode = ResultCode.builder().code(500).msg("Internal Server Error").build();

    ApiException() {
        super();
    }

    ApiException( String message ) {
        this(-1, message);
    }

    ApiException( int code, String message ) {
        super(message);
        this.code = code;
    }

    ApiException( int code, String message, Object... args ) {
        super(message);
        this.code = code;
        this.args = args;
    }

    ApiException( ResultCode resultCode) {
        super();
        this.resultCode = resultCode;
    }

    ApiException( int code, String message, ResultCode resultCode) {
        super(message);
        this.code = code;
        this.resultCode = resultCode;
    }

    ApiException( int code, String message, ResultCode resultCode, Object... args ) {
        super(message);
        this.code = code;
        this.resultCode = resultCode;
        this.args = args;
    }

    public static void notNull(@Nullable Object object) {
        if(object == null) {
            throw new ApiException();
        }
    }

    public static void notNull(@Nullable Object object, String message) {
        if(object == null) {
            throw new ApiException(message);
        }
    }

    public static void notNull(@Nullable Object object, int code, String message) {
        if(object == null) {
            throw new ApiException(code, message);
        }
    }

    public static void notNull(@Nullable Object object, int code, String message, Object... args) {
        if(object == null) {
            throw new ApiException(code, message, args);
        }
    }

    public static void notNull(@Nullable Object object, ResultCode resultCode) {
        if(object == null) {
            throw new ApiException(resultCode);
        }
    }

    public static void notNull(@Nullable Object object, int code, String message, ResultCode resultCode) {
        if(object == null) {
            throw new ApiException(code, message, resultCode);
        }
    }

    public static void notNull(@Nullable Object object, int code, String message, ResultCode resultCode, Object... args) {
        if(object == null) {
            throw new ApiException(code, message, resultCode, args);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ApiException();
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, String message) {
        if(CollectionUtils.isEmpty(collection)) {
            throw new ApiException(message);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, int code, String message) {
        if(CollectionUtils.isEmpty(collection)) {
            throw new ApiException(code, message);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, int code, String message, Object... args) {
        if(CollectionUtils.isEmpty(collection)) {
            throw new ApiException(code, message, args);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, ResultCode resultCode) {
        if(CollectionUtils.isEmpty(collection)) {
            throw new ApiException(resultCode);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, int code, String message, ResultCode resultCode) {
        if(CollectionUtils.isEmpty(collection)) {
            throw new ApiException(code, message, resultCode);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, int code, String message, ResultCode resultCode, Object... args) {
        if(CollectionUtils.isEmpty(collection)) {
            throw new ApiException(code, message, resultCode, args);
        }
    }

    public static void state(boolean expression) {
        if (!expression) {
            throw new ApiException();
        }
    }

    public static void state(boolean expression, String message) {
        if(!expression) {
            throw new ApiException(message);
        }
    }

    public static void state(boolean expression, int code, String message) {
        if(!expression) {
            throw new ApiException(code, message);
        }
    }

    public static void state(boolean expression, int code, String message, Object... args) {
        if(!expression) {
            throw new ApiException(code, message, args);
        }
    }

    public static void state(boolean expression, ResultCode resultCode) {
        if(!expression) {
            throw new ApiException(resultCode);
        }
    }

    public static void state(boolean expression, int code, String message, ResultCode resultCode) {
        if(!expression) {
            throw new ApiException(code, message, resultCode);
        }
    }

    public static void state(boolean expression, int code, String message, ResultCode resultCode, Object... args) {
        if(!expression) {
            throw new ApiException(code, message, resultCode, args);
        }
    }
}
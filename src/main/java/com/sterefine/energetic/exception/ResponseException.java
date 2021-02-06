package com.sterefine.energetic.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.aop.framework.AopConfigException;

import java.awt.geom.IllegalPathStateException;
import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum ResponseException implements ResponseAssert{

    AOP_CONFIG(AopConfigException.class, ResultCode.builder().code(1).msg("111").build()),
    BUSINESS_EXCEPTION(BusinessException.class, ResultCode.builder().code(2).msg("222").build()),
    ILLEGAL_PATH_STATE(IllegalPathStateException.class, ResultCode.builder().code(3).msg("333").build());

    private Class<? extends RuntimeException> exceptionType;
    private ResultCode resultCode;

    public static ResultCode getResultCodeByException(Class<? extends RuntimeException> e) {
        return Arrays.stream(values())
                .filter( o -> o.getExceptionType().equals(e.getClass()))
                .findFirst()
                .map( responseException -> responseException.getResultCode())
                .orElse(null);
    }
}
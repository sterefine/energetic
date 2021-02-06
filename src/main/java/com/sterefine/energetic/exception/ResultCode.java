package com.sterefine.energetic.exception;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class ResultCode {
    public int code;
    public String msg;
}

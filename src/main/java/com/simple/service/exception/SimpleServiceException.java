package com.simple.service.exception;

import com.simple.service.enums.ResultEnums;

public class SimpleServiceException extends RuntimeException {

    private Integer code;

    public SimpleServiceException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

package com.simple.service.enums;

/**
 * 枚举类，定义系统错误码及对应错误信息
 */
public enum ResultEnums {
    UNKONW_ERROR(-1,"unkonw_error"),
    SUCCESS(0,"success"),
    Error(1,"error");

    private Integer code;

    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

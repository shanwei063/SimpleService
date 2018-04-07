package com.simple.service.bean;

/**
 * 定义返回类型，状态码，信息，数据
 * @param <T>
 */
public class Result<T> {

    //code
    private Integer code;

    //msg
    private String msg;

    //具体返回信息
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

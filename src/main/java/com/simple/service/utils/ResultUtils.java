package com.simple.service.utils;

import com.simple.service.bean.Result;
import com.simple.service.enums.ResultEnums;

/**
 * 封装Result返回的数据
 */
public class ResultUtils {

    public static Result success(Object object)
    {
        Result result = new Result();
        result.setCode(ResultEnums.SUCCESS.getCode());
        result.setMsg(ResultEnums.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success()
    {
        return success(null);
    }

    public static Result error(Integer code,String msg)
    {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

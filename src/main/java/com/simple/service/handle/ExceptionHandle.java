package com.simple.service.handle;

import com.simple.service.bean.Result;
import com.simple.service.enums.ResultEnums;
import com.simple.service.exception.SimpleServiceException;
import com.simple.service.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获异常，统一处理，内部直接throw错误信息即可
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(Exception.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e)
    {
        if (e instanceof SimpleServiceException)
        {
            //调用ResultUtils类，将异常信息转换为统一输出
            return ResultUtils.error(((SimpleServiceException) e).getCode(),e.getMessage());
        }
        else
        {
            //避免直接将不可控错误信息打印至界面
            logger.error("【系统错误】",e);
            return ResultUtils.error(ResultEnums.UNKONW_ERROR.getCode(),ResultEnums.UNKONW_ERROR.getMsg());
        }
    }
}

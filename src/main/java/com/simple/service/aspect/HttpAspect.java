package com.simple.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.simple.service.controller.TestController.*(..))")
    public void common() {
    }

    @Before("common()")
    public void doBefore(JoinPoint joinPoint)
    {
        logger.info("start..........");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteHost());
        //class method
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //args
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("common()")
    public void doAfter()
    {
        logger.info("end........");
    }

    @AfterReturning(returning = "object",pointcut = "common()")
    public void doAfterReturning(Object object)
    {
        logger.info("response={}",object.toString());
    }
}

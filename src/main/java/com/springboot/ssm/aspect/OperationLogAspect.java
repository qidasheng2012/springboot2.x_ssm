package com.springboot.ssm.aspect;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.springboot.ssm.domain.OperationLog;
import com.springboot.ssm.service.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Objects;

@Component
@Aspect
@Slf4j
public class OperationLogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperationLogService operationLogService;

    @Pointcut("@annotation(com.springboot.ssm.aspect.OperationLogAble)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        // 获取请求方式：GET/POST/PUT/DELETE
        String httpMethod = request.getMethod();
        // 获取请求地址
        String uri = request.getRequestURI();


        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 获取方法所有参数名称
        Parameter[] parameters = method.getParameters();

        // 获取方法所有参数值
        Object[] args = joinPoint.getArgs();

        // 将所有参数及参数对应的值封装在map中
        int length = parameters.length;
        HashMap<Object, Object> paramMap = Maps.newHashMapWithExpectedSize(length);
        for (int i = 0; i < length; i++) {
            Parameter parameter = parameters[i];
            if (Objects.nonNull(args[i])) {
                paramMap.put(parameter.getName(), args[i]);
            }
        }

        // 获取注解中的值
        OperationLogAble operationLogAble = method.getAnnotation(OperationLogAble.class);
        String resource = operationLogAble.resource();

        // TODO 通过权限框架获取用户信息
        int userId = 1;

        OperationLog operationLog = OperationLog.builder()
                .httpMethod(httpMethod)
                .uri(uri)
                .resouce(resource)
                .operationUserId(userId)
                .paramJson(JSON.toJSONString(paramMap))
                .build();


        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            operationLog.toBuilder()
                    .status(1)
                    .build();
            operationLogService.save(operationLog);
            throw e;
        }

        operationLogService.save(operationLog);
        return result;
    }
}

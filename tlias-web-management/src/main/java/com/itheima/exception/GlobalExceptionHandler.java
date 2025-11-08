package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalStateException.class)     // 更具体：先匹配这里
    public Result handleIllegalState(IllegalStateException e) {
        log.warn("业务校验失败: {}", e.getMessage());
        return Result.error(e.getMessage());
    }

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程序出错: ", e);
        return Result.error("出错，请联系管理员");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("程序出错: ", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2] + "已存在");
    }

}

package com.example.springbootdemo.exception;


import com.example.springbootdemo.pojo.dto.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice    // 统一处理
public class GlobalExceptionHandlerAdvice {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler({Exception.class})    // 所有异常的统一处理
    public ResponseMessage handlerException(Exception e, HttpServletRequest request, HttpServletResponse response){

        // Recording Log
        log.error("统一异常：", e);
        return new ResponseMessage(500,"error",null);
    }
}

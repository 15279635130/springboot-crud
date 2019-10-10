package com.test.restfulcrud.component;

import com.test.restfulcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 传入错误状态码
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user not exist");
        map.put("message", e.getMessage());
        request.setAttribute("extError", map);
        return "forward:/error";
    }
}

package com.test.restfulcrud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 让容器中加入自定义错误处理信息
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("company", "attest");
        Map<String, Object> map = (Map<String, Object>) webRequest.getAttribute("extError", 0);
        errorAttributes.put("extError", map);
        return errorAttributes;
    }
}

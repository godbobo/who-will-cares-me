package com.aqzscn.lonely.handler;

import com.aqzscn.lonely.utils.JacksonUtil;
import com.aqzscn.lonely.vo.ReturnVo;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class JsonResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Object result;
        if (body instanceof ReturnVo) {
            result = body;
        } else if (body instanceof String) {
            // 因为StringHttpMessageConverter会直接把字符串写入body, 所以字符串特殊处理
            result = JacksonUtil.me().toJson(ReturnVo.success(body));
        } else {
            // 其他类型进行统一包装
            result = ReturnVo.success(body);
        }

        return result;
    }
}

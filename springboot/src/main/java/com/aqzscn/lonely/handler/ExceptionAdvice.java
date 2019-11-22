package com.aqzscn.lonely.handler;

import com.aqzscn.lonely.vo.AppException;
import com.aqzscn.lonely.vo.GlobalNames;
import com.aqzscn.lonely.vo.ReturnVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    // 捕获自定义的异常
    @ExceptionHandler(value = AppException.class)
    @ResponseBody
    public ReturnVo exceptionHandler(HttpServletRequest request, HttpServletResponse response, AppException e) {
        e.printStackTrace();
        String message;
        if (e.getErrorCode() >= GlobalNames.unknownError) {
            message = e.getMessage();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } else {
            message = GlobalNames.responseCodeName.getOrDefault(e.getErrorCode(), "未知的错误类型");
            response.setStatus(e.getErrorCode());
        }
        logger.error(message);
        return ReturnVo.error(message);
    }

    // 捕获全局异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnVo exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return ReturnVo.error(e.getMessage());
    }

}

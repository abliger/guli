package com.atguigu.guli.service.base.handle;


import com.atguigu.guli.service.base.exception.GuliException;
import com.atguigu.guli.service.base.result.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author abliger
 */
@ControllerAdvice
@Slf4j

public class GlobalExceptionHandler {
    /**
     * Exception全局异常处理
     * @param e Exception
     * @return R
     */
    @ExceptionHandler
    @ResponseBody
    public R exceptHandle(Exception e){
        String stackTrace = ExceptionUtils.getStackTrace(e);
        String message = e.getMessage();
        log.warn(stackTrace);
        //System.out.println(stackTrace);
        return R.error().data("error",message);
    }

    /**
     * guliException全局异常处理
     * @param e GuliException
     * @return R
     */
    @ExceptionHandler
    @ResponseBody
    public R guliExceptHandle(GuliException e){
        String stackTrace = ExceptionUtils.getStackTrace(e);
        String message = e.getMessage();
        log.info(stackTrace);
        //System.out.println(stackTrace);
        return R.error().code(e.getCode()).message(message);
    }
}

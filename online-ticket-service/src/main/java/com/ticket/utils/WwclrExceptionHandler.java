package com.ticket.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wwclr on 2019/3/12.
 * 配置监控到程序错误后的跳转页面地址
 */
@ControllerAdvice
public class WwclrExceptionHandler {
//    这里的 ERROR_PAGE是html页面地址
    public static final String ERROR_PAGE="error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,HttpServletResponse response,Exception e) throws Exception{
        e.printStackTrace();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("exception",e.getMessage());
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName(ERROR_PAGE);
        return modelAndView;
    }
}

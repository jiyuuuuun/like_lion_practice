package com.example.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; //slf4j 사용
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e, Model model) {
        logger.error(e.getMessage(), e); //sout를 쓰면 시스템 성능이 낮아질수 있으므로 Logger 사용
        System.out.println("error ::::::::::::::"+e);
        model.addAttribute("msg", e.getMessage());
        return new ModelAndView("error");
    }
}

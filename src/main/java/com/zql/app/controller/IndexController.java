package com.zql.app.controller;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/9/12.
 */
@Controller
public class IndexController {


    @RequestMapping("/")
    public String index(){
        return "forward:/foo";
    }


    @RequestMapping("/error")
    public String error(Model model, HttpServletRequest request){
        System.out.println(request.getAttribute(WebAttributes.ACCESS_DENIED_403));
        return "error";
    }
}

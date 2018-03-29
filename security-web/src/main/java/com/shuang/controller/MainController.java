package com.shuang.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by shuang on 2018/3/28.
 */
@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainController {

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        //UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //model.addAttribute("userDetails", userDetails);
        return "index";
    }

    @PreAuthorize("hasAuthority('TEST')")
    @RequestMapping("/user/index")
    public String userIndex(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        model.addAttribute("userDetails", userDetails);
        return "user/index";
    }

//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String postLogin() {
//        // TODO Enable form login with Spring Security (trigger error for now)
//        return "redirect:/login-error";
//    }
//
//    @RequestMapping("/login-error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login";
//    }

    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public String processException(Model model, Exception exception, HttpServletResponse response) {
        int status = response.getStatus();
        model.addAttribute("status", status);
        model.addAttribute("error", exception.getMessage());
        return "error";
    }
}

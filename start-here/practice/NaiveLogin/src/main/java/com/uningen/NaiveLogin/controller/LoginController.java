package com.uningen.NaiveLogin.controller;

import com.uningen.NaiveLogin.service.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String getLogin(){
        return "login.html";
    }

    @PostMapping("/")
    public String postLogin(
            @RequestParam String username,
            @RequestParam String password,
            LoginProcessor loginProcessor,
            Model model
    ){
       boolean loggedIn = loginProcessor.login();
       if(loggedIn){
           model.addAttribute("message", "You are now logged in");
       }
       else {
           model.addAttribute("message", "Login failed!");
       }
       return "login.html";
    }

}

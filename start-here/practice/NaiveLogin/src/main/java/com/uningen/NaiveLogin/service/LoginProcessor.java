package com.uningen.NaiveLogin.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(){
        String username = this.getUsername();
        String password = this.getPassword();
        System.out.println(username);
        System.out.println(password);

        if("natalie".equals(username) && "password".equals(password)){
            return true;
        }
        else {
            return false;
        }
    }
}

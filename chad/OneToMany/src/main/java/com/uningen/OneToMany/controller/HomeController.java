package com.uningen.OneToMany.controller;

import com.uningen.OneToMany.dao.AppDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private AppDAO appDAO;

    public HomeController(AppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @GetMapping("/instructors")
    public String getInstructors(){
        return "Hey there!";
    }
}

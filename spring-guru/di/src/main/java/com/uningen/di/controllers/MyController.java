package com.uningen.di.controllers;

import com.uningen.di.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHi(){
        System.out.println("I'm in the controller");
        return greetingService.sayGreeting();
    }
}

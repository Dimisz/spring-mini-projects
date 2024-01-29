package com.uningen.di.controllers;

import com.uningen.di.services.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MyControllerTest {
    @Autowired
    GreetingService greetingService;
    @Test
    void sayHello(){
        MyController myController = new MyController(greetingService);
        System.out.println("Running test...");
        System.out.println(myController.sayHi());
    }
}

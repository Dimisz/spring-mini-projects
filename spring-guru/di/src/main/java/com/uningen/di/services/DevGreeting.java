package com.uningen.di.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class DevGreeting implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Greetings from DEV!";
    }
}

package com.uningen.di.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"qa", "default"})
@Service
public class QaGreeting implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Greetings from QA!";
    }
}

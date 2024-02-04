package com.uningen.di.services;

//@Service
//@Primary
public class GreetingServicePrimary implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello from PRIMARY greeting service";
    }
}

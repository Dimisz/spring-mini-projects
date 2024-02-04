package com.uningen.di.services;

//@Service
public class GreetingServiceImpl implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello everyone from base service";
    }
}

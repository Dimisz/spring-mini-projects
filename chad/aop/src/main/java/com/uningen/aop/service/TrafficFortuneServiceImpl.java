package com.uningen.aop.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {

        // simulate delay
        try {
            TimeUnit.SECONDS.sleep(5);
//            throw new RuntimeException("EXEPTION FOR TESTING PURPOSES");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // return a fortune
        return "Expect heavy traffic this morning";

    }

    @Override
    public String getFortune(boolean throwExeption) {
        if(throwExeption){
            throw new RuntimeException("TEST EXEPTION");
        }
        return getFortune();
    }
}

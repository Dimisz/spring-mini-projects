package com.uningen.main;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    private String name;

    public Dog() {
        System.out.println("Creating a dog...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog: " + name;
    }
}

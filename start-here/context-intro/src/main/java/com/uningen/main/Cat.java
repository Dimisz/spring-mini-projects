package com.uningen.main;

import org.springframework.stereotype.Component;

@Component
public class Cat {
    private String name;

    public Cat() {
        System.out.println("Creating a cat...");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat: " + name;
    }
}

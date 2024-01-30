package com.uningen.main;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    public Parrot() {
        System.out.println("Creating a parrot...");
    }

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}

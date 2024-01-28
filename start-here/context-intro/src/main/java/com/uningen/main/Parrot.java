package com.uningen.main;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    public Parrot() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Parrot: " + name;
    }
}

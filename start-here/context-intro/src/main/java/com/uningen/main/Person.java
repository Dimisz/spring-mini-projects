package com.uningen.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Jenna";

//    @Autowired
    private Parrot parrot;
//    @Autowired
    private Dog dog;
//    @Autowired
    private Cat cat;

    public Person() {
        System.out.println("Creating a person...");
    }

    @Autowired
    public Person(Parrot parrot, Dog dog) {
        this.name = name;
        this.parrot = parrot;
        this.dog = dog;
        this.cat = cat;
        System.out.println("Created person " + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
        System.out.println("Assigned a cat using setter");
    }

    @Override
    public String toString() {
        String personName = this.name == null ? "Incognito" : name;
        if(this == null) return "Incognito";
        if(this.parrot == null && this.dog == null && this.cat == null){
            return personName + " has no pets";
        }

        return personName + " has " +
                ((this.parrot == null) ? " no parrot" : " a parrot " + parrot.getName()) +
                ((this.cat == null) ? ", no cat" : ", a cat " + cat.getName()) +
                ((this.dog == null) ? ", and no dog" : ", and a dog " + dog.getName());
    }
}

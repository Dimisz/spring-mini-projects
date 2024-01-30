package com.uningen.main;

import com.uningen.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);


        Parrot parrot = context.getBean(Parrot.class);
        parrot.setName("Sparrow");
        Parrot parrot2 = context.getBean(Parrot.class);
        parrot.setName("Kiki");

        Cat cat = context.getBean(Cat.class);
        cat.setName("Fluffy");
        Dog dog = context.getBean(Dog.class);
        dog.setName("Lucky");
        Person person = context.getBean(Person.class);
        person.setName("Ella");


        System.out.println(person);
//        System.out.println(parrot);
//        System.out.println(cat);
//        System.out.println(dog);
    }
}

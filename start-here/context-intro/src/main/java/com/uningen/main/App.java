package com.uningen.main;

import com.uningen.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;


public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        Parrot p = context.getBean(Parrot.class);
//        System.out.println();
//        p.setName("Kiko");
//        System.out.println(p.getName());
//
//        Dog d = context.getBean(Dog.class);
//        d.setName("Lucky");
//        System.out.println(d.getName());
            Cat c = new Cat();
            c.setName("Fluffy");

        Supplier<Cat> catSupplier = () -> c;
        context.registerBean("cat1", Cat.class, catSupplier);

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat.getName());
    }
}

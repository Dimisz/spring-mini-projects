package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    private final EmployeeRepository employeeRepository;

    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void loadData(){
        employeeRepository.saveAll(List.of(
                new Employee("Lselie", "Andrews", "leslie@luv2code.com"),
                new Employee("Emma", "Baumgarten", "emma@luv2code.com"),
                new Employee("Avani", "Gupta", "avani@luv2code.com"),
                new Employee("Yuri", "Petrov", "yuri@luv2code.com"),
                new Employee("Juan", "Vega", "juan@luv2code.com")
        ));
    }
}

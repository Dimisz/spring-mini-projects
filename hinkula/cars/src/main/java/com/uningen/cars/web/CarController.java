package com.uningen.cars.web;

import com.uningen.cars.domain.Car;
import com.uningen.cars.domain.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private CarRepository carRepository;

    public CarController(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @GetMapping
    Iterable<Car> getCars(){
        return carRepository.findAll();
    }

//    @GetMapping("/{id}")
//    Optional<Car> getCarById(@PathVariable Long id){
//        return carRepository.findById(id);
//    }
}

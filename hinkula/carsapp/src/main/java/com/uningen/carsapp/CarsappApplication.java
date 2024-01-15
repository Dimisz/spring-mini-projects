package com.uningen.carsapp;

import com.uningen.carsapp.domain.Car;
import com.uningen.carsapp.domain.CarRepository;
import com.uningen.carsapp.domain.Owner;
import com.uningen.carsapp.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CarsappApplication implements CommandLineRunner {
	private static final Logger logger =
			LoggerFactory.getLogger(
					CarsappApplication.class
			);
	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;
	public CarsappApplication(CarRepository carRepository,
							  OwnerRepository ownerRepository){
		this.carRepository = carRepository;
		this.ownerRepository = ownerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarsappApplication.class, args);
	}

	@Override
	public void run(String ...args) throws Exception {
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));

		carRepository.save(new Car("Ford", "Mustang", "Red",
				"ADF-1121", 2023, 59000, owner1));
		carRepository.save(new Car("Nissan", "Leaf", "White",
				"SSJ-3002", 2020, 29000, owner2));
		carRepository.save(new Car("Toyota", "Prius", "Silver",
				"KKO-0212", 2022, 39000, owner2));

		for(Car car: carRepository.findAll()){
			logger.info("brand: {}, model: {}",
					car.getBrand(), car.getModel());
		}
	}

}

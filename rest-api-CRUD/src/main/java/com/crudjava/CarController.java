package com.crudjava;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CarController {

	CarRepository repostory;
	
	@GetMapping("/car")
	public List<Car> getAllCars(){
		return repostory.findAll();
	}

	@GetMapping("/car{id}")
	public Car getCarById(@PathVariable Long id) {
		return repostory.findById(id).get();
	}

	@PostMapping("/car")
	public Car saveCar(@RequestBody Car car){
		return repostory.save(car);
	}

	@DeleteMapping("/car/{id}")
	public void deleteCar(@PathVariable Long id){
		repostory.deleteById(id);
	}
}

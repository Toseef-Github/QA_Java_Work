package com.qa.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.domain.Car;
import com.qa.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService service; // dependency

	@GetMapping("/demoCar")
	public Car getDemoCar() {
		return new Car("BMW", "M3", 2001);
	}

	@GetMapping("/getCar/{id}")
	public Car getById(@PathVariable int id) {
		return this.service.getById(id);
	}

	@GetMapping("/getCars")
	public List<Car> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/getCarByMake/{make}")
	public Car getCarByMake(@PathVariable String make) {
		return this.service.findByMake(make);
	}
	
	@PostMapping("/createCar")
	public ResponseEntity<Car> create(@RequestBody Car car) {
		System.out.println("Created: " + car);
		Car created = this.service.create(car);
		
		return new ResponseEntity<Car>(created, HttpStatus.CREATED);
	}

	@PatchMapping("/updateCar/{id}")
	public Car update(@PathVariable("id") int id, @PathParam("make") String make,
			@PathParam("model") String model, @PathParam("reg") Integer reg) {
		return this.service.update(id, make, model, reg);
	}

	// id = 4494
	@DeleteMapping("/removeCar/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
package com.qa.service;

import java.util.List;

import com.qa.domain.Car;

public interface CarService {

	Car getById(int id);

	List<Car> getAll();

	Car findByMake(String make);

	Car create(Car car);

	Car update(int id, String make, String model, Integer reg);

	void delete(int id);

}

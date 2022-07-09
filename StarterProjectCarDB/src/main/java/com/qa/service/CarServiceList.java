package com.qa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.domain.Car;

@Service

public class CarServiceList implements CarService {

	private List<Car> cars = new ArrayList<>();

	@Override
	public Car getById(int id) {
		return this.cars.get(id);

	}

	@Override
	public List<Car> getAll() {
		return this.cars;
	}

	@Override
	public Car create(Car car) {
		this.cars.add(car);
		return this.cars.get(this.cars.size() - 1);

	}

	@Override
	public Car update(int id, String make, String model, Integer reg) {
		Car toUpdate = this.cars.get(id);
		if (make != null)
			toUpdate.setMake(make);
		if (model != null)
			toUpdate.setModel(model);
		if (reg != null)
			toUpdate.setReg(reg);
		return toUpdate;
	}

	@Override
	public void delete(int id) {
		this.cars.remove(id);
	}

	@Override
	public Car findByMake(String make) {
		return null;
	}

}
	
package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.domain.Car;
import com.qa.repo.CarRepo;

@Service
@Primary
public class CarServiceDB implements CarService {

	@Autowired
	private CarRepo repo;

	@Override
	public Car getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Car> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Car create(Car car) {
		return this.repo.save(car);
	}

	@Override
	public Car update(int id, String make, String model, Integer reg) {
		Car toUpdate = this.getById(id);
		if (make != null)
			toUpdate.setMake(make);
		if (model != null)
			toUpdate.setModel(model);
		if (reg != null)
			toUpdate.setReg(reg);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public Car findByMake(String make) {
		return this.repo.findByMakeStartingWithIgnoreCase(make);
	}

}
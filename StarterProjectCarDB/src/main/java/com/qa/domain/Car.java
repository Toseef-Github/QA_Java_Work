package com.qa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Table
public class Car {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer id;

	@Column(name = "carMake", nullable = false, unique = true)
	private String make;

	private String model;

	private int reg;

	public Car() {
		super();
		// REQUIRED
	}

	public Car(String make, String model, int reg) {
		super();
		this.make = make;
		this.model = model;
		this.reg = reg;
	}
	
	public Car(Integer id, String make, String model, int reg) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.reg = reg;
	}

	// REQUIRED

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getReg() {
		return this.reg;
	}

	public void setReg(int reg) {
		this.reg = reg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.reg;
		result = prime * result + ((this.make == null) ? 0 : this.make.hashCode());
		result = prime * result + ((this.model == null) ? 0 : this.model.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (this.reg != other.reg)
			return false;
		if (this.make == null) {
			if (other.make != null)
				return false;
		} else if (!this.make.equals(other.make))
			return false;
		if (this.model == null) {
			if (other.model != null)
				return false;
		} else if (!this.model.equals(other.model))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [make=" + this.make + ", model=" + this.model + ", reg=" + this.reg + "]";
	}

}
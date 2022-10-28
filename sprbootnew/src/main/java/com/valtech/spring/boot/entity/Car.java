package com.valtech.spring.boot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String make;
	private String model;
	private int yearManufactured;
	private String color;
	private int kms;
	private float price;
	
	public Car(){}
	public Car(String make, String model, int yearManufactured, String color, int kms, float price) {
		this.make = make;
		this.model = model;
		this.yearManufactured = yearManufactured;
		this.color = color;
		this.kms = kms;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYearManufactured() {
		return yearManufactured;
	}
	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getKms() {
		return kms;
	}
	public void setKms(int kms) {
		this.kms = kms;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}

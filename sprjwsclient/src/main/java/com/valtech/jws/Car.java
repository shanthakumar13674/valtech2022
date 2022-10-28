package com.valtech.jws;

public class Car {
	
	private int id;
	private String make;
	private String model;
	private int yearMfg;
	private String color;
	private float price;
	
	public Car(){}
	public Car(int id, String make, String model, int yearMfg, String color, float price) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.yearMfg = yearMfg;
		this.color = color;
		this.price = price;
	}
	
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", yearMfg=" + yearMfg + ", color=" + color
				+ ", price=" + price + "]";
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
	public int getYearMfg() {
		return yearMfg;
	}
	public void setYearMfg(int yearMfg) {
		this.yearMfg = yearMfg;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}

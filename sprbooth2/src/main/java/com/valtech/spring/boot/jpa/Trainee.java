package com.valtech.spring.boot.jpa;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private int gender;
	private LocalDate dateOfBirth;
	private float salary;
	
	public Trainee(){}
	public Trainee(int id, String name, String email, int gender, LocalDate dateOfBirth, float salary) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
	}
	public Trainee(String name, String email, int gender, LocalDate dateOfBirth, float salary) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
	}

	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", salary=" + salary + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
}

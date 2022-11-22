package com.valtech.cart.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
	
	private int id;
	private String name;
	private LocalDate birthDate;

}

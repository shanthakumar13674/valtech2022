package com.valtech.cart.vo;

// VO is used for holding data btw the presentation and service layers.
public class ProductVO {
	
	private long id;
	private String name;
	private float cost;
	private int quantity;
	private float taxRate;
	private float tax;
	
	public ProductVO(long id, String name, float cost, int quantity, float taxRate, float tax) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		this.taxRate = taxRate;
		this.tax = tax;
	}
	public ProductVO() {}

	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", cost=" + cost + ", quantity=" + quantity + ", taxRate="
				+ taxRate + ", tax=" + tax + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}

}

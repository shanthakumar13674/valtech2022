package com.valtech.cart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LineItem {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long productId;
	private int quantity;
	private float lineCost;
	private float taxCost;
	private float lineTotal; // cost + tax
	
	public LineItem(long productId, int quantity, float lineCost, float taxCost) {
		this.productId = productId;
		this.quantity = quantity;
		this.lineCost = lineCost;
		this.taxCost = taxCost;
		this.lineTotal = lineCost+taxCost;
	}
	public LineItem(long id, long productId, int quantity, float lineCost, float taxCost) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.lineCost = lineCost;
		this.taxCost = taxCost;
		this.lineTotal = lineCost+taxCost;
	}
	public LineItem() {
	}
	@Override
	public String toString() {
		return "LineItem [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", lineCost=" + lineCost
				+ ", taxCost=" + taxCost + ", lineTotal=" + lineTotal + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getLineCost() {
		return lineCost;
	}
	public void setLineCost(float lineCost) {
		this.lineCost = lineCost;
	}
	public float getTaxCost() {
		return taxCost;
	}
	public void setTaxCost(float taxCost) {
		this.taxCost = taxCost;
	}
	public float getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(float lineTotal) {
		this.lineTotal = lineTotal;
	}
	
}

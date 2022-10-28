package valtechspring.orm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("atx")
public class AtmTx extends Tx	{
	
	private int atmNo;
	private String location;
	
	public AtmTx() {
	}

	public AtmTx(float amount,int atmNo, String location) {
		super(amount);
		this.atmNo = atmNo;
		this.location = location;
	}

	public int getAtmNo() {
		return atmNo;
	}

	public void setAtmNo(int atmNo) {
		this.atmNo = atmNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String toString() {
		return "AtmTx [getId()=" + getId() + ", getAmount()=" + getAmount() + ", atmNo=" + atmNo + ", location="
				+ location + "]";
	}
}

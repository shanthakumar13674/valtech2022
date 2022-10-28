package valtechspring.orm;

import javax.persistence.Embeddable;

@Embeddable
public class CarDetails {
	
	private int kms;
	private boolean validInsurance;
	private int numOfOwners;
	
	public CarDetails(){}
	public CarDetails(int kms, boolean validInsurance, int numOfOwners) {
		this.kms = kms;
		this.validInsurance = validInsurance;
		this.numOfOwners = numOfOwners;
	}

	@Override
	public String toString() {
		return "CarDetails [kms=" + kms + ", validInsurance=" + validInsurance + ", numOfOwners=" + numOfOwners + "]";
	}
	public int getKms() {
		return kms;
	}
	public void setKms(int kms) {
		this.kms = kms;
	}
	public boolean isValidInsurance() {
		return validInsurance;
	}
	public void setValidInsurance(boolean validInsurance) {
		this.validInsurance = validInsurance;
	}
	public int getNumOfOwners() {
		return numOfOwners;
	}
	public void setNumOfOwners(int numOfOwners) {
		this.numOfOwners = numOfOwners;
	}

}

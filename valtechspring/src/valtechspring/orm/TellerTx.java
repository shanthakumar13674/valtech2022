package valtechspring.orm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ttx")
public class TellerTx extends Tx	{
	
	private String teller;
	private String branch;
	
	public TellerTx() {
	}

	public TellerTx(float amount,String teller, String branch) {
		super(amount);
		this.teller = teller;
		this.branch = branch;
	}

	public String getTeller() {
		return teller;
	}

	public void setTeller(String teller) {
		this.teller = teller;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "TellerTx [getId()=" + getId() + ", getAmount()=" + getAmount() + ", teller=" + teller + ", branch="
				+ branch + "]";
	}

}

package valtechspring.orm;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class BankAccountId implements Serializable {

	private int accountNo;
	private String accounType;

	public BankAccountId() {
	}

	public BankAccountId(int accountNo, String accounType) {
		this.accountNo = accountNo;
		this.accounType = accounType;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounType == null) ? 0 : accounType.hashCode());
		result = prime * result + accountNo;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountId other = (BankAccountId) obj;
		if (accounType == null) {
			if (other.accounType != null)
				return false;
		} else if (!accounType.equals(other.accounType))
			return false;
		if (accountNo != other.accountNo)
			return false;
		return true;
	}

	// @Override
	// public int hashCode() {
	// return HashCodeBuilder.reflectionHashCode(this);
	// }
	// @Override
	// public boolean equals(Object obj) {
	// return EqualsBuilder.reflectionEquals(this, obj);
	// }
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccounType() {
		return accounType;
	}

	public void setAccounType(String accounType) {
		this.accounType = accounType;
	}

}

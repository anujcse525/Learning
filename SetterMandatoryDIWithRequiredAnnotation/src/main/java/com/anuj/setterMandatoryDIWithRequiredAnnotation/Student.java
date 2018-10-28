package com.anuj.setterMandatoryDIWithRequiredAnnotation;

import org.springframework.beans.factory.annotation.Required;

public class Student {
	private String name;
	private int roll;
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	@Required
	public void setRoll(int roll) {
		this.roll = roll;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address adress) {
		this.address = adress;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + ", address=" + address + "]";
	}

}

package com.anuj.poly;

public class Car {
	private String model;

	public Car(String model) {
		this.model = model;
	}
	
	private static void performance(){
		System.out.println("Car Performance");
	}

	public String getModel() {
		return model;
	}


}

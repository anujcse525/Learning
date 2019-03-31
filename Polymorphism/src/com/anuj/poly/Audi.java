package com.anuj.poly;

public class Audi extends Car {
	public String model;
	public Audi(String model) {
		super(model);
		this.model = model;
	}

	private static  void performance(){
		System.out.println("Audi Performance");
	}
	

}

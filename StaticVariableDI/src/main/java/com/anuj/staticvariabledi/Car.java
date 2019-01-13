package com.anuj.staticvariabledi;

public class Car {

	private static String carName;

	public static void setCarName(String name) {
		Car.carName = name;
	}

	public static void printCar() {
		System.out.println("Car : " + carName);
	}
}

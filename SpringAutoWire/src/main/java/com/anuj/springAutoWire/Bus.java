package com.anuj.springAutoWire;

public class Bus {
	private Engine engine;

	public Bus() {
		System.out.println("Default constructor called");
	}
	public Bus(Engine engine) {
		super();
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		System.out.println("Setter is called");
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Bus [engine=" + engine + "]";
	}
	
	
}

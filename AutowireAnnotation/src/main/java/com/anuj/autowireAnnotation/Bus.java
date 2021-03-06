package com.anuj.autowireAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Bus {

	@Qualifier(value="e1")
	@Autowired()
	private Engine engine;
	// No need to have any constructor and setter method

	public Engine getEngine() {
		return engine;
	}

	@Override
	public String toString() {
		return "Bus [engine=" + engine + "]";
	}

}

package com.anuj.stereotype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anuj.engine.Engine;

@Component
public class Car {
	
	@Autowired
	private Engine engine;

	@Override
	public String toString() {
		return "Car [engine=" + engine + "]";
	}
	
}

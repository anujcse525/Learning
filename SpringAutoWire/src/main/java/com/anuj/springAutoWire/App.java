package com.anuj.springAutoWire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("resource/spring.xml");
		Car car = (Car) ap.getBean("car");
		System.out.println(car);
	}
}
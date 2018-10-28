package com.anuj.springAutoWire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BusApp {

	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("resource/spring_autodetect.xml");
		Bus bus = (Bus) ap.getBean("bus");
		System.out.println(bus);
	}

}

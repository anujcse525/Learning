package com.anuj.autowireAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("resource/spring.xml");
		Bus bus = (Bus) ap.getBean("bus");
		System.out.println(bus);
	}
}

package com.anuj.springNameSpace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("resource/spring.xml");
		Car car = (Car) app.getBean("car");
		System.out.println(car);
	}
}

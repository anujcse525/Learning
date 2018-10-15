package com.anuj.propertiesdifile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("resources/spring.xml");
		TestProperties tp = (TestProperties) ac.getBean("test");
		tp.printProperties();
	}
}
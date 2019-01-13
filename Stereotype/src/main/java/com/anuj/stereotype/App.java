package com.anuj.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext con = new ClassPathXmlApplicationContext("resource/spring.xml");
        Car car = (Car) con.getBean(Car.class);
        System.out.println(car);
    }
}

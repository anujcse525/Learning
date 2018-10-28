package com.anuj.setterMandatoryDIWithRequiredAnnotation;

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
        ApplicationContext ap = new ClassPathXmlApplicationContext("resource/spring.xml");
        Student st = (Student) ap.getBean("student");
        System.out.println(st);
        
    }
}

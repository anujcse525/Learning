package com.anuj.propertiesdi;

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
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        PropertiesTest pt = (PropertiesTest) ac.getBean("test");
        pt.printProperties();
    }
}

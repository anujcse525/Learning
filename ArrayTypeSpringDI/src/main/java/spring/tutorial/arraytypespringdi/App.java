package spring.tutorial.arraytypespringdi;

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
        ApplicationContext ac = new ClassPathXmlApplicationContext("resource/arraypass.xml");
        Car car = (Car) ac.getBean("car");
        System.out.println(car);
    }
}

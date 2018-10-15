package spring.tutorial.SecondaryTypeSpringDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//		String[] files = new String[] { "resource/car.xml", "resource/engine.xml" };
//		ApplicationContext ac = new ClassPathXmlApplicationContext(files);
		ApplicationContext ac = new ClassPathXmlApplicationContext("resource/car-engine.xml");
		Car car = (Car) ac.getBean("car");
		System.out.println(car);
	}
}

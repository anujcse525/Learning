package spring.tutorial.SpringLearning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApplicationContext {

	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("resource/spring.xml");
		
		Test test = (Test) appCon.getBean("test");
		//test.getMessage(); // Will print Hello Hello, which we are passing from spring.xml as a property
		System.out.println(test);
		//System.out.println(test.getAge());
		//Test test1= (Test) appCon.getBean("test");
		
	}

}

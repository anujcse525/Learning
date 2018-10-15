package spring.tutorial.SpringLearning;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
	private Client() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Resource res = new ClassPathResource("resource/spring.xml");
		BeanFactory factory = new XmlBeanFactory(res);

		Test test = (Test) factory.getBean("test");
		//test.getMessage();
		Test test1 = (Test) factory.getBean("test");
		Test test2 = (Test) factory.getBean("test");
	}
}

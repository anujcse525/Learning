package spring.tutorial.collectiondi;

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
        Test test = (Test) ac.getBean("test");
        System.out.println(test);
    }
}

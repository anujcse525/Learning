package protein.protein;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		System.out.println("hello");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
	}

}

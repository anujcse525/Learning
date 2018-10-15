package protein.protein;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {
		try {
			Configuration config = new Configuration().configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		} catch (Exception ex) {
			System.out.println("Exception occured : " + ex.getMessage());
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}

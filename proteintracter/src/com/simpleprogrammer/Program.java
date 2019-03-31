package com.simpleprogrammer;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		populateSampleData();

		Session session = HibernateUtilities.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//Query query = session.getNamedQuery("AllGoalAlerts");

		Query query = session.createQuery("select new com.simpleprogrammer.UserTotal(user.name, user.proteinData.total)" + "from User user");
		List<UserTotal> userList = query.list();

		for (UserTotal alert : userList) {
			System.out.println(alert);
		}
		
		session.getTransaction().commit();
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}

	public static void populateSampleData() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		User2 joe = createUser2("Joe", 500, 50, "Good Job", "You Made It!");
		session.save(joe);

		/*User bob = createUser("Bob", 300, 20, "Taco Time!");
		session.save(bob);

		User amy = createUser("Amy", 250, 220, "Yes!!!");
		session.save(amy);*/

		session.getTransaction().commit();
		session.close();

	}

	private static User createUser(String name, int goal, int total, String... alerts) {
		User user = new User();
		user.setName(name);
		user.getProteinData().setGoal(goal);
		user.getProteinData().setTotal(total);
		user.addHistory(new UserHistory(new Date(System.currentTimeMillis()), "Set the goal to " + goal));
		user.addHistory(new UserHistory(new Date(System.currentTimeMillis()), "Set the total to " + total));

		for (String str : alerts) {
			user.getGoalAlerts().add(new GoalAlert(str));
		}

		return user;
	}
	private static User2 createUser2(String name, int goal, int total, String... alerts) {
		User2 user = new User2();
		user.setName(name);
		user.getProteinData().setGoal(goal);
		user.getProteinData().setTotal(total);
		user.addHistory(new UserHistory(new Date(System.currentTimeMillis()), "Set the goal to " + goal));
		user.addHistory(new UserHistory(new Date(System.currentTimeMillis()), "Set the total to " + total));

		for (String str : alerts) {
			user.getGoalAlerts().add(new GoalAlert(str));
		}

		return user;
	}
}

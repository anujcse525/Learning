package com.anuj.repository;

import java.util.ArrayList;
import java.util.List;

import com.anuj.model.Activity;
import com.anuj.model.ActivitySearch;
import com.anuj.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	@Override
	public void create(Activity activity) {
		// Here we can store into DB
		
	}
	
	/* (non-Javadoc)
	 * @see com.anuj.repository.ActivityRepository#getAllActivities()
	 */
	@Override
	public List<Activity> getAllActivities()
	{
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration(55);

		Activity activity2 = new Activity();
		activity2.setDescription("Cycling");
		activity2.setDuration(120);
		
		Activity activity3 = new Activity();
		activity3.setDescription("Sports");
		activity3.setDuration(90);
		
		activities.add(activity1);
		activities.add(activity2);
		activities.add(activity3);
		
		return activities;
	}

	@Override
	public Activity getAcitivity(String activityId) {
		Activity activity = new Activity();
		activity.setId(Integer.parseInt(activityId));
		activity.setDescription("Sports");
		activity.setDuration(90);
		
		User user = new User();
		user.setId("525");
		user.setName("Anuj");
		activity.setUser(user);
		return activity;
	}

	@Override
	public Activity update(Activity activity) {
//Search the database, if already there update,otherwise insert	
		return activity;
	}

	@Override
	public void delete(String activityId) {
		//Delete from DB
		
	}

	@Override
	public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {
		System.out.println("DurationFrom : " + durationFrom + " -- DurationTo : " + durationTo);
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity = new Activity();
		activity.setDescription("Cricket");
		activity.setDuration(90);
		activity.setId(4567);
		activities.add(activity);
		return activities;
	}

	@Override
	public List<Activity> findByConstraints(ActivitySearch activitySearch) {
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity = new Activity();
		activity.setDescription("Cricket");
		activity.setDuration(90);
		activity.setId(4567);
		activities.add(activity);
		return activities;
	}

}

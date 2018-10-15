package com.anuj.repository;

import java.util.List;

import com.anuj.model.Activity;
import com.anuj.model.ActivitySearch;

public interface ActivityRepository {

	List<Activity> getAllActivities();

	Activity getAcitivity(String activityId);

	void create(Activity activity);

	Activity update(Activity activity);

	void delete(String activityId);

	List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

	List<Activity> findByConstraints(ActivitySearch activity);

}
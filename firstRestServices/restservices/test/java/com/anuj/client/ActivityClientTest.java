package com.anuj.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.anuj.model.Activity;
import com.anuj.model.ActivitySearch;

public class ActivityClientTest {

	@Test
	public void testGetActivity() {
		ActivityClient client = new ActivityClient();
		Activity activity= client.getActivity("1234");
		System.out.println(activity);
		Assert.assertNotNull(activity);
	}

	@Test
	public void testGetActivityList(){
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.getActivityList();
		Assert.assertNotNull(activities);
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetActivityException(){
		ActivityClient client = new ActivityClient();
		Activity activity = client.getActivity("123");
		
	}
	
	@Test
	public void testCreate(){
		Activity activity = new Activity();
		activity.setDescription("Swimming");
		activity.setDuration(90);
		ActivityClient client = new ActivityClient();
		activity = client.create(activity);
		
	}
	
	@Test
	public void testPut(){
		Activity activity = new Activity();
		activity.setId(1111);
		activity.setDescription("Yoga");
		activity.setDuration(90);
		ActivityClient client = new ActivityClient();
		client.update(activity);
		
		Assert.assertNotNull(activity);
	}
	
	@Test
	public void testDelete(){
		ActivityClient client = new ActivityClient();
		client.delete("1234");
	}
	
	@Test
	public void testSearch(){
		ActivitySearchClient client = new ActivitySearchClient();
		String param = "description";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("Cricket");
		searchValues.add("yoga");
		
		List<Activity> activities = client.searchActivity(param, searchValues);
		
		Assert.assertNotNull(activities);
	}
	
	@Test
	public void testSearchInRange(){
		ActivitySearchClient client = new ActivitySearchClient();
		String param = "description";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("Cricket");
		searchValues.add("yoga");
		
		String secondParam = "durationFrom";
		int durationFrom = 30;
		
		String thirdParam = "durationTo";
		int durationTo = 55;
		
		List<Activity> activities = client.searchActivityWithARange(param, searchValues, secondParam, durationFrom, thirdParam, durationTo);
		
		Assert.assertNotNull(activities);
	}
	
	@Test
	public void testActivitySearch(){
		ActivitySearchClient client = new ActivitySearchClient();
		
		List<String> searchValues = new ArrayList<String>();
		
		searchValues.add("Running");
		searchValues.add("Walking");
		
		ActivitySearch search = new ActivitySearch();
		search.setDescription(searchValues);
		search.setDurationFrom(30);
		search.setDurationTo(55);
		
		List<Activity> result = client.searchWithSearchObj(search);
		
		Assert.assertNotNull(result);
		
	}
	
}

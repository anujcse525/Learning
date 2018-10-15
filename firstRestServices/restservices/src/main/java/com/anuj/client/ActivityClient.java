package com.anuj.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anuj.model.Activity;

public class ActivityClient {

	private Client client;

	public ActivityClient() {
		client = ClientBuilder.newClient();
	}

	public Activity getActivity(String id) {
		WebTarget target = client.target("http://localhost:8080/restservices/webapi/");

		Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
		System.out.println(response);
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : There was an error in the reponse");
		}
		return response.readEntity(Activity.class);
	}

	public List<Activity> getActivityList() {
		WebTarget target = client.target("http://localhost:8080/restservices/webapi/");
		List<Activity> activityList = target.path("activities").request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Activity>>() {
				});
		return activityList;
	}

	public Activity create(Activity activity) {// http://localhost:8080/restservices/webapi/activities/activity
		WebTarget target = client.target("http://localhost:8080/restservices/webapi/");

		Response response = target.path("activities/activity").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		System.out.println(response);
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : There was an error in the reponse");
		}
		return response.readEntity(Activity.class);
	}

	public Activity update(Activity activity) {
		WebTarget target = client.target("http://localhost:8080/restservices/webapi/");
		Response response = target.path("activities/" + activity.getId()).request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(activity, MediaType.APPLICATION_JSON));

		System.out.println(response);
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : There was an error in the reponse");
		}
		return response.readEntity(Activity.class);

	}

	public void delete(String id) {
		WebTarget target = client.target("http://localhost:8080/restservices/webapi/");
		Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).delete();

		System.out.println(response);
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : There was an error in the reponse");
		}

	}
}

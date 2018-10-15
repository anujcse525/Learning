package com.anuj.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.anuj.model.Activity;
import com.anuj.model.ActivitySearch;

public class ActivitySearchClient {

	Client client = null;

	public ActivitySearchClient() {
		client = ClientBuilder.newClient();
	}

	public List<Activity> searchActivity(String param, List<String> searchValues) {
		URI uri = UriBuilder.fromUri("http://localhost:8080/restservices/webapi/").path("search/activities")
				.queryParam(param, searchValues).build();

		WebTarget target = client.target(uri);

		List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
		});

		System.out.println(response);

		return response;
	}

	public List<Activity> searchActivityWithARange(String param, List<String> searchValues, String secondParam,
			int durationFrom, String thirdParam, int durationTo) {
		URI uri = UriBuilder.fromUri("http://localhost:8080/restservices/webapi/").path("search/activities")
				.queryParam(param, searchValues).queryParam(secondParam, durationFrom)
				.queryParam(thirdParam, durationTo).build();

		WebTarget target = client.target(uri);

		List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
		});

		System.out.println(response);

		return response;
	}

	public List<Activity> searchWithSearchObj(ActivitySearch search) {

		URI uri = UriBuilder.fromUri("http://localhost:8080/restservices/webapi/").path("search/activities").build();

		WebTarget target = client.target(uri);

		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(search, MediaType.APPLICATION_JSON));

		System.out.println(response);

		return response.readEntity(new GenericType<List<Activity>>() {
		});
	}
}

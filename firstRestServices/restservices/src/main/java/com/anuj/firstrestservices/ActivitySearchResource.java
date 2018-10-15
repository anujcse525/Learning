package com.anuj.firstrestservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.anuj.model.Activity;
import com.anuj.model.ActivitySearch;
import com.anuj.repository.ActivityRepository;
import com.anuj.repository.ActivityRepositoryStub;

@Path("search/activities")
public class ActivitySearchResource {

	private ActivityRepository activityRepo = new ActivityRepositoryStub();
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchActivities(ActivitySearch activity){
		
		System.out.println(activity);
		
		List<Activity> activities = activityRepo.findByConstraints(activity);
		
		if(activities == null || activities.size() == 0){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok(new GenericEntity<List<Activity>> (activities){}).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchActivities(@QueryParam(value="description") List<String> descriptions, @QueryParam(value="durationFrom") int durationFrom, @QueryParam(value = "durationTo") int durationTo){
		System.out.println(descriptions);
		
		List<Activity> activities = activityRepo.findByDescription(descriptions, durationFrom, durationTo);
		
		if(activities == null || activities.size() ==0){
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(new GenericEntity<List<Activity>> (activities){}).build();
	}
	
	
	
	
}

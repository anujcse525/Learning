package com.anuj.firstrestservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.anuj.model.Activity;
import com.anuj.model.User;
import com.anuj.repository.ActivityRepository;
import com.anuj.repository.ActivityRepositoryStub;

@Path("activities") //http://localhost:8080/restservices/web-api/activities
public class ActivityResource {
	private ActivityRepository activityRepo = new ActivityRepositoryStub();
	
	@DELETE
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("activityId") String activityId)
	{
		System.out.println(activityId);
		
		activityRepo.delete(activityId);
		return Response.ok().build();
	}
	
	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response update(Activity activity)
	{
		System.out.println(activity.getId());
		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		activityRepo.update(activity);
		return Response.ok(activity).build();
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Activity createActivityParamsWithBinding(Activity activity)
	{
		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		
		return activity;
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Activity createActivityParams(MultivaluedMap<String, String> formParams)
	{
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		
		Activity activity = new Activity();
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		
		activityRepo.create(activity);
		
		return activity;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Activity> getAllActivities()
	{
		return activityRepo.getAllActivities();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{activityId}")
	public Response getActivity(@PathParam ("activityId") String activityId)
	{
		if(activityId == null || activityId.length() < 4){
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Activity activity = activityRepo.getAcitivity(activityId);
		if(activity == null){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok(activity).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{activityId}/user")
	public User getActivityUser(@PathParam ("activityId") String activityId)
	{
		return activityRepo.getAcitivity(activityId).getUser();
	}
}

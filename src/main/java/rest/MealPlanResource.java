package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MealPlanDTO;
import facades.MealPlanFacade;
import utils.EMF_Creator;


import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("mealplan")
public class MealPlanResource {
    @Context
    private UriInfo context;

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final MealPlanFacade facade =  MealPlanFacade.getMealPlanFacade(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Path("getall/{user_name}")
    @GET
    @Produces("text/plain")
    public String getMealPlanByUser(@PathParam("user_name") String username) {
        return gson.toJson(facade.getAllMealPlansByUser(username));
    }

    @POST
    @Path("create/{id}/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createMealPlan(@PathParam("id") Integer id, @PathParam("username") String username, String jsonInput){
        MealPlanDTO mealPlanDTO = gson.fromJson(jsonInput, MealPlanDTO.class);
        MealPlanDTO returned = facade.createMealPlan(mealPlanDTO, id, username);
        return Response.ok().entity(gson.toJson(returned)).build();
    }

    @PUT
    @Path("update/{mealPlanId}/{mealId}/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateMealPlan(@PathParam("mealPlanId") Integer mealPlanId, @PathParam("mealId") Integer mealId, @PathParam("username") String username, String jsonInput){
        MealPlanDTO mealPlanDTO = gson.fromJson(jsonInput, MealPlanDTO.class);
        mealPlanDTO.setId(mealPlanId);
        MealPlanDTO returned = facade.updateMealPlan(mealPlanDTO, mealId, username);
        return Response.ok().entity(gson.toJson(returned)).build();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteMealPlan(@PathParam("id") Integer id) {
        MealPlanDTO mealPlanDTO = facade.deleteMealPlan(id);
        return Response.ok().entity(gson.toJson(mealPlanDTO)).build();
    }
}

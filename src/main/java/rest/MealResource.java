package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MealDTO;
import facades.MealFacade;
import facades.MealPlanFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("meal")
public class MealResource {

    @Context
    private UriInfo context;

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final MealFacade facade =  MealFacade.getMealFacade(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Path("getall/{meal_plan}")
    @GET
    @Produces("text/plain")
    public String getMealPlanByUser(@PathParam("meal_plan") String mealPlan) {
        return gson.toJson(facade.getAllMealsByMealPlan(mealPlan));
    }

    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createMeal(String jsonInput){
        MealDTO mealDTO = gson.fromJson(jsonInput, MealDTO.class);
        MealDTO returned = facade.createMeal(mealDTO);
        return Response.ok().entity(gson.toJson(returned)).build();
    }

    @PUT
    @Path("update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateMeal(@PathParam("id") Integer id, String jsonInput){
        MealDTO mealDTO = gson.fromJson(jsonInput, MealDTO.class);
        mealDTO.setId(id);
        MealDTO returned = facade.updateMeal(mealDTO);
        return Response.ok().entity(gson.toJson(returned)).build();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") Integer id) {
        MealDTO mealDTO = facade.deleteMeal(id);
        return Response.ok().entity(gson.toJson(mealDTO)).build();
    }
}

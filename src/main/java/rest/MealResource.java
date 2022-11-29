package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.MealFacade;
import facades.MealPlanFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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
}

package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.MealPlanFacade;
import utils.EMF_Creator;


import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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
    public String getMealPlanByUser(@PathParam("user_name") String user_name) {
        return gson.toJson(facade.getAllMealPlansByUser(user_name));
    }

}

package rest;

import com.google.gson.Gson;
import dtos.*;
import utils.HttpUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

@Path("search")
public class RecipeResource {
    @Context
    private UriInfo context;

    @Path("meals/{ingredient}")
    @GET
    @Produces("text/plain")
    public String getMealsByIngredient(@PathParam("ingredient") String ingredient) throws IOException {
        Gson gson = new Gson();
        MealsDTO mealsDTO = new MealsDTO();
        String meals = HttpUtils.fetchData(mealsDTO.getUrl() + ingredient);
        mealsDTO = gson.fromJson(meals, MealsDTO.class);
        return gson.toJson(mealsDTO);
    }

    @Path("recipe/name/{name}")
    @GET
    @Produces("text/plain")
    public String getRecipeByName(@PathParam("name") String name) throws IOException {
        Gson gson = new Gson();
        RecipeDTO recipeDTO = new RecipeDTO();
        String recipe = HttpUtils.fetchData(recipeDTO.getUrlName() + name);
        recipeDTO = gson.fromJson(recipe, RecipeDTO.class);
        return gson.toJson(recipeDTO);
    }

    @Path("recipe/id/{idMeal}")
    @GET
    @Produces("text/plain")
    public String getRecipeById(@PathParam("idMeal") String idMeal) throws IOException {
        Gson gson = new Gson();
        RecipeDTO recipeDTO = new RecipeDTO();
        String recipe = HttpUtils.fetchData(recipeDTO.getUrlId() + idMeal);
        recipeDTO = gson.fromJson(recipe, RecipeDTO.class);
        return gson.toJson(recipeDTO);
    }
}

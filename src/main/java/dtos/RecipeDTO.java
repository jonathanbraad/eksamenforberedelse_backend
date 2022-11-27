package dtos;

import java.util.ArrayList;

public class RecipeDTO {

    private ArrayList<Object> meals;

    private String urlName = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    private String urlId = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=";

    public RecipeDTO(ArrayList<Object> meals, String urlName, String urlId) {
        this.meals = meals;
        this.urlName = urlName;
        this.urlId = urlId;
    }

    public RecipeDTO() {
    }

    public ArrayList<Object> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Object> meals) {
        this.meals = meals;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }
}

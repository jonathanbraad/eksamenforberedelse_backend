package dtos;

import java.util.ArrayList;

public class MealsDTO {

    private ArrayList<Object> meals;

    private String url = "https://www.themealdb.com/api/json/v1/1/filter.php?i=";

    public MealsDTO(ArrayList<Object> meals, String url) {
        this.meals = meals;
        this.url = url;
    }

    public MealsDTO() {
    }

    public ArrayList<Object> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Object> meals) {
        this.meals = meals;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

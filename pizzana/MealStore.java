package pizzana;

import pizzana.meals.Meal;

public abstract class MealStore {
  
    public Meal orderMeal(String type) {
        Meal meal = createMeal(type);
        System.out.println("Preparing " + meal.getName() + "...");
        // Additional steps like packaging, etc. can go here (Template Method)
        return meal;
    }

    // The Factory Method
    protected abstract Meal createMeal(String type);
}
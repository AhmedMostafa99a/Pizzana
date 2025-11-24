package pizzana;

import pizzana.meals.Meal;
import pizzana.meals.PizzaMeal;

public class ItalianPizzaStore extends MealStore {
    @Override
    protected Meal createMeal(String type) {
        if (type.equalsIgnoreCase("Italian")) {
            return new PizzaMeal("Classic Italian Pizza", 70.0);
        } else if (type.equalsIgnoreCase("Margherita")) {
            return new PizzaMeal("Margherita Pizza", 60.0);
        } else {
            return new PizzaMeal("Generic Italian Pizza", 65.0);
        }
    }
}
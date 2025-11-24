package pizzana;

import pizzana.meals.BurgerMeal;
import pizzana.meals.Meal;

public class BurgerStore extends MealStore {
    @Override
    protected Meal createMeal(String type) {
        if (type.equalsIgnoreCase("Classic")) {
            return new BurgerMeal("Classic Beef Burger", 55.0);
        } else if (type.equalsIgnoreCase("Chicken")) {
            return new BurgerMeal("Chicken Burger", 50.0);
        } else {
            return new BurgerMeal("Generic Burger", 45.0);
        }
    }
}
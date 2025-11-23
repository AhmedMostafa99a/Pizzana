package pizzana;

import pizzana.meals.Meal;
import pizzana.meals.SimpleMeal;

public class BurgerStore extends MealStore {
 
    @Override
    protected Meal createBurger(String type, double cost) {
        return new SimpleMeal(type, cost);
    }
}

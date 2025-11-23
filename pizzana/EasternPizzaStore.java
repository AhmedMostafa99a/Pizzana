package pizzana;

import pizzana.meals.Meal;
import pizzana.meals.SimpleMeal;

public class EasternPizzaStore extends MealStore {
    @Override
    protected Meal createPizza(String type, double cost) {
        return new SimpleMeal(type, cost);
    }

}

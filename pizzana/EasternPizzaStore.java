package pizzana;

import pizzana.meals.Meal;
import pizzana.meals.PizzaMeal;

public class EasternPizzaStore extends MealStore {
    @Override
    protected Meal createMeal(String type) {
        if (type.equalsIgnoreCase("Sausage")) {
            return new PizzaMeal("Eastern Sausage Pizza", 80.0);
        } else if (type.equalsIgnoreCase("Pastrami")) {
            return new PizzaMeal("Eastern Pastrami Pizza", 85.0);
        } else {
            return new PizzaMeal("Generic Eastern Pizza", 75.0);
        }
    }
}
package pizzana;

import pizzana.meals.BurgerMeal;
import pizzana.meals.Meal;
import pizzana.meals.PizzaMeal;
import pizzana.meals.SimpleMeal;
import pizzana.meals.VegMeals;

public class VegetarianFactory implements IMenuFactory {
    @Override
    public Meal createPizza() {
        return new SimpleMeal("Veggie Pizza", 55.0);
    }

    @Override
    public Meal createBurger() {
        return new SimpleMeal("Veggie Burger", 45.0);
    }

    @Override
    public Meal createChickenMeal() {
        return new SimpleMeal("Tofu Meal", 40.0);
    }
}

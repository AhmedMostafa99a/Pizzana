package pizzana;

import pizzana.meals.BurgerMeal;
import pizzana.meals.ChickenMeal;
import pizzana.meals.Meal;
import pizzana.meals.PizzaMeal;
import pizzana.meals.SimpleMeal;

public class NonVegFactory implements IMenuFactory {
    @Override
    public Meal createPizza() {
        return new SimpleMeal("Non-Veg Supreme Pizza", 65.0);
    }

    @Override
    public Meal createBurger() {
        return new SimpleMeal("Non-Veg Beef Burger", 55.0);
    }

    @Override
    public Meal createChickenMeal() {
        return new SimpleMeal("Non-Veg Chicken Meal", 50.0);
    }
}

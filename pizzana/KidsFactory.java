package pizzana;

import pizzana.meals.BurgerMeal;
import pizzana.meals.ChickenMeal;
import pizzana.meals.Meal;
import pizzana.meals.PizzaMeal;
import pizzana.meals.SimpleMeal;

public class KidsFactory implements IMenuFactory {
 @Override
    public Meal createPizza() {
        return new SimpleMeal("Kids Pizza", 25.0);
    }

    @Override
    public Meal createBurger() {
        return new SimpleMeal("Kids Burger", 20.0);
    }

    @Override
    public Meal createChickenMeal() {
        return new SimpleMeal("Kids Chicken Nuggets", 15.0);
    }
}

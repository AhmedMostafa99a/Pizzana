package pizzana;

import pizzana.meals.Meal;
import pizzana.meals.SimpleMeal;

public class KidsFactory implements IMenuFactory {
    @Override
    public Meal createAppetizer() {
        return new SimpleMeal("Mini Fries", 1.50);
    }

    @Override
    public Meal createMainCourse() {
        return new SimpleMeal("Kid Burger", 3.50);
    }

    @Override
    public Meal createSalad() {
        return new SimpleMeal("Fruit Cup", 2.00);
    }
}

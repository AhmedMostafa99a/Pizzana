package pizzana;

import pizzana.meals.Meal;
import pizzana.meals.SimpleMeal;

public class VegetarianFactory implements IMenuFactory {
    @Override
    public Meal createAppetizer() {
        return new SimpleMeal("Veg Spring Roll", 2.50);
    }

    @Override
    public Meal createMainCourse() {
        return new SimpleMeal("Veggie Pasta", 6.00);
    }

    @Override
    public Meal createSalad() {
        return new SimpleMeal("Garden Salad", 3.00);
    }
}

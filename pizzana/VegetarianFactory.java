package pizzana;

import pizzana.meals.*;;


public class VegetarianFactory implements IMenuFactory {
    @Override
    public Meal createPizza() {
        return new PizzaMeal("Veggie Pizza", 55.0);
    }

    @Override
    public Meal createBurger() {
        return new BurgerMeal("Veggie Burger", 45.0);
    }

    @Override
    public Meal createChickenMeal() {
        return new ChickenMeal("Tofu Meal", 40.0);
    }
}

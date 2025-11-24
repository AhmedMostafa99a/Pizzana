package pizzana;

import pizzana.meals.Meal;

public interface IMenuFactory {
    Meal createPizza();
    Meal createBurger();
    Meal createChickenMeal();
}
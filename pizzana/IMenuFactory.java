package pizzana;

import pizzana.meals.Meal;

public interface IMenuFactory {
    Meal createAppetizer();
    Meal createMainCourse();
    Meal createSalad();
}
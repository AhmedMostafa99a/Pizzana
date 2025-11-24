package pizzana;

import pizzana.meals.Meal;
import pizzana.IMenuFactory;

public class MenuDisplaySystem {

    public void showMainMenu() {
        System.out.println("===== Main Menu =====");
        System.out.println("1. Kids Menu");
        System.out.println("2. Vegetarian Menu");
        System.out.println("3. Non-Vegetarian Menu");
        System.out.println("=====================");
    }

    public void showKidsMenu(IMenuFactory factory) {
        System.out.println("\n===== Kids Menu (Abstract Factory) =====");
       for (Meal meal : new Meal[]{
            factory.createPizza(),
            factory.createBurger(),
            factory.createChickenMeal()
        }) {
            System.out.println(meal.getName() + " - $" + meal.getCost());
        }
        System.out.println("========================================");
    }

    public void showVegetarianMenu(IMenuFactory factory) {
        System.out.println("\n===== Vegetarian Menu =====");
       for (Meal meal : new Meal[]{
            factory.createPizza(),
            factory.createBurger(),
            factory.createChickenMeal()
        }) {
            System.out.println(meal.getName() + " - $" + meal.getCost());
        }
        System.out.println("==============================================");
    }

    public void showNonVegMenu(IMenuFactory factory) {
        System.out.println("\n===== Non-Vegetarian Menu =====");
       for (Meal meal : new Meal[]{
            factory.createPizza(),
            factory.createBurger(),
            factory.createChickenMeal()
        }) {
            System.out.println(meal.getName() + " - $" + meal.getCost());
        }
        System.out.println("==================================================");
    }
}
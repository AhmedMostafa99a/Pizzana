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
        System.out.println("\n===== Kids Menu =====");
        int i = 1;
       for (Meal meal : new Meal[]{
            factory.createPizza(),
            factory.createBurger(),
            factory.createChickenMeal()
        }) {
            System.out.println(i + meal.getName() + " - $" + meal.getCost());
            i++;
        }
        System.out.println("========================================");
    }

    public void showVegetarianMenu(IMenuFactory factory) {
        System.out.println("\n===== Vegetarian Menu =====");
        int i = 1;
       for (Meal meal : new Meal[]{
            factory.createPizza(),
            factory.createBurger(),
            factory.createChickenMeal()
        }) {
            System.out.println(i + meal.getName() + " - $" + meal.getCost());
            i++;
        }
        System.out.println("==============================================");
    }

    public void showNonVegMenu(IMenuFactory factory) {
        System.out.println("\n===== Non-Vegetarian Menu =====");
        int i = 1;
       for (Meal meal : new Meal[]{
            factory.createPizza(),
            factory.createBurger(),
            factory.createChickenMeal()
        }) {
            System.out.println(i + meal.getName() + " - $" + meal.getCost());
            i++;
        }
        System.out.println("==================================================");
    }
}
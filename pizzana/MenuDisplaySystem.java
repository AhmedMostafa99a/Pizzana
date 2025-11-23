package pizzana;

import java.util.ArrayList;
import pizzana.meals.BurgerMeal;
import pizzana.meals.Meal;
import pizzana.meals.PizzaMeal;

public class MenuDisplaySystem {

    // Main menu receives meals dynamically from Main
    public void showMainMenu(ArrayList<PizzaMeal> pizzas, ArrayList<BurgerMeal> burgers) {
        System.out.println("===== Main Menu =====");
    
        System.out.println("Pizzas:");
        for (int i = 0; i < pizzas.size(); i++) {
        PizzaMeal pizza = pizzas.get(i);
        System.out.println((i + 1) + ". " + pizza.getName() + " - " + pizza.getCost() + "$");
    }

        System.out.println("\nBurgers:");
        for (int i = 0; i < burgers.size(); i++) {
            BurgerMeal burger = burgers.get(i);
            System.out.println((i + 1) + ". " + burger.getName() + " - " + burger.getCost() + "$");
        }

        System.out.println("\nAdd-ons:");
        System.out.println("- Extra Cheese (+1.50$)");
        System.out.println("- Extra Sauce (+0.75$)");
        System.out.println("- Beetroot Jam (+0.90$)");

        System.out.println("============================================");
    }

    public void showKidsMenu(IMenuFactory factory) {
        System.out.println("===== Kids Menu (Abstract Factory) =====");
        printFactoryMeals(factory);
    }

    public void showVegetarianMenu(IMenuFactory factory) {
        System.out.println("===== Vegetarian Menu =====");
        printFactoryMeals(factory);
    }

    public void showNonVegMenu(IMenuFactory factory) {
        System.out.println("===== Non-Veg Menu =====");
        printFactoryMeals(factory);
    }

    private void printFactoryMeals(IMenuFactory factory) {
        Meal appetizer = factory.createAppetizer();
        Meal main = factory.createMainCourse();
        Meal salad = factory.createSalad();

        System.out.println("Appetizer: " + appetizer.getName() + " - " + appetizer.getCost() + "$");
        System.out.println("Main Course: " + main.getName() + " - " + main.getCost() + "$");
        System.out.println("Salad: " + salad.getName() + " - " + salad.getCost() + "$");
        System.out.println("=====================================");
    }
}

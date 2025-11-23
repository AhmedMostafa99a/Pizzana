package pizzana;

public class MenuDisplaySystem {

    public void showMainMenu() {
        System.out.println("===== Main Menu (Factory Method Meals) =====");

        System.out.println("Pizzas:");
        System.out.println("1) Italian Pizza - 8.00$");
        System.out.println("2) Eastern Pizza - 7.50$");

        System.out.println("\nBurgers:");
        System.out.println("3) Classic Burger - 5.00$");

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

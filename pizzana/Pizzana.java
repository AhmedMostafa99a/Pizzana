package pizzana;
import pizzana.payments.*;
import java.util.ArrayList;

import java.util.Scanner;

import pizzana.bills.*;
import pizzana.discounts.*;
import pizzana.meals.Meal;
import pizzana.observers.*;
import pizzana.payments.*;

public class Pizzana {

    public static void main(String[] args) {
        ArrayList<Meal> burgers = new ArrayList<Meal>();
        ArrayList<Meal> pizzas = new ArrayList<Meal>();
        System.out.println("Welcome to Pizzana!");
        Scanner scanner = new Scanner(System.in);

        MenuDisplaySystem menuDisplay = new MenuDisplaySystem();
        menuDisplay.showMainMenu(burgers, pizzas);
        System.out.print("Please select your meal options: ");
        Integer mealOptions = scanner.nextInt();
        ArrayList<OrderItem> orderItems = new ArrayList<>();

        while (true)
        {
            System.out.print("Enter meal name (or 'done' to finish): ");
            String mealName = scanner.nextLine();
            if (mealName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter quantity: ");
            Integer quantity = scanner.nextInt();

            System.out
        }
        
    }
}

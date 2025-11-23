package pizzana;
import pizzana.payments.*;
import java.util.ArrayList;

import java.util.Scanner;

import pizzana.bills.*;
import pizzana.discounts.*;
import pizzana.observers.*;
import pizzana.payments.*;

public class Pizzana {

    public static void main(String[] args) {
        System.out.println("Welcome to Pizzana!");
        Scanner scanner = new Scanner(System.in);

        MenuDisplaySystem menuDisplay = new MenuDisplaySystem();
        menuDisplay.showMainMenu();
        System.out.print("Please select your meal options: ");
        Integer mealOptions = scanner.nextInt();
        ArrayList<OrderItem> orderItems = new ArrayList<>();

        while (true)
        {
            System.out.print("Enter meal name to add to order (or type 'done' to finish): ");
            System.out.println("DO u want to add any extra ?");
            scanner.
            scanner.close();
        }
        


    }
}

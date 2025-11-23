package pizzana;
import pizzana.payments.*;

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


    }
}

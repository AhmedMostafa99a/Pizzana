package pizzana;
import pizzana.payments.*;
import java.util.ArrayList;

import java.util.Scanner;

import pizzana.bills.*;
import pizzana.discounts.*;
import pizzana.observers.*;
import pizzana.payments.*;
import pizzana.meals.*;

public class Pizzana {

    public static void main(String[] args) {
 

        Scanner scanner = new Scanner(System.in);
       MenuDisplaySystem menuDisplay = new MenuDisplaySystem();
       ArrayList<PizzaMeal> pizzas = new ArrayList<>();
        pizzas.add(new PizzaMeal("Italian Pizza" , 50.0));
        pizzas.add(new PizzaMeal("Eastern Pizza", 45.0));


        ArrayList<BurgerMeal> burgers = new ArrayList<>();
        burgers.add(new BurgerMeal("Classic Burger", 40.0));

        ArrayList<Meal> total_meals = new ArrayList<>();
        total_meals.addAll(pizzas);
        total_meals.addAll(burgers);

        menuDisplay.showMainMenu(pizzas, burgers);

        Order order = new Order();
        // While adding new meals to order
mealsLoop:
        while (true){
            // While adding extra items to a meal
            System.out.print("Please select your meal options: ");
            Integer mealOption = scanner.nextInt();
            Meal selectedMeal = null;
            if(mealOption != 1 && mealOption != 2 && mealOption != 3){
                System.out.println("Invalid meal option. Please try again.");
                continue;
            }
            switch (mealOption) {

                case 1 :
                    selectedMeal = pizzas.get(0);
                    break;
                case 2 :
                    selectedMeal = pizzas.get(1);
                    break;
                case 3 :
                    selectedMeal = burgers.get(0);
                    break;
                default:
                    System.out.println("Invalid meal option. Please try again.");
                    continue;
            }
extraLoop:
            while (true)
            {
                System.out.println("Do u want to add any extra (extra code or -1 for none)?");
                Integer extraOption = scanner.nextInt();
                if (extraOption == -1){
                    System.out.print("Enter quantity of this meal: ");
                    Integer quantity = scanner.nextInt();
                    order.addMeal(selectedMeal, quantity);
                    break;
                } else {
                    switch (extraOption) {
                        case 1:
                            selectedMeal = new ExtraCheese(selectedMeal);
                            break;
                        case 2:
                            selectedMeal = new ExtraSauce(selectedMeal);
                            break;
                        case 3:
                            selectedMeal = new ExtraBeetrootJam(selectedMeal);
                            break;
                        default:
                            System.out.println("Invalid extra option. Please try again.");
                            continue extraLoop;
                    }
                    System.out.println("Extra added. Current meal: " + selectedMeal.getName() + " - " + selectedMeal.getCost() + "$");
                }
            }
            while (true){
                System.out.println("Do you want to add more meals? (yes/no)");
                String moreMeals = scanner.next();
                if (moreMeals.equalsIgnoreCase("no")){
                    break mealsLoop;
                } else if (moreMeals.equalsIgnoreCase("yes")){
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
        }
        BillingService billingService = new BillingService();
        // Discounts
        Discount pizzaDiscount = new PizzaDiscount();
        Discount meatDiscount = new MeatDiscount();
        Discount chicketDiscount = new ChickenDiscount();
        billingService.addDiscount(pizzaDiscount);
        billingService.addDiscount(meatDiscount);
        billingService.addDiscount(chicketDiscount);
        // Creating bill
        Bill bill = billingService.createBill(order);
        System.out.println(bill.toString());
        System.out.println("Please select payment method (1: Credit Card, 2: Mobile Wallet, 3: Cash): ");
        Integer paymentMethod = scanner.nextInt();
        PaymentMethod paymentStrategy = null;
        switch (paymentMethod) {
            case 1:
                System.out.print("Enter credit card number: ");
                String cardNumber = scanner.nextLine();
                paymentStrategy = new CreditPayment(cardNumber);
                break;
            case 2:
                System.out.print("Enter mobile number: ");
                String mobileNumber = scanner.nextLine();
                paymentStrategy = new MobileWalletPayment(mobileNumber);
                break;
            case 3:
                paymentStrategy = new CashPayment();
                break;
            default:
                System.out.println("Invalid payment method. Defaulting to Cash.");
                paymentStrategy = new CashPayment();
                break;
        }
        System.out.println("Are you sure you want to pay " + bill.getTotalPrice() + "? (yes/no)");
        String confirmPayment = scanner.next();
        if (confirmPayment.equalsIgnoreCase("yes")) {
            billingService.payBill(bill, paymentStrategy);
        } else {
            System.out.println("Payment cancelled.");
            return;
        }
        System.out.println("Thank you for dining at Pizzana!");
        System.out.println("Have a nice meal!");
        scanner.close();
        billingService.payBill(bill, paymentStrategy);
    }
}

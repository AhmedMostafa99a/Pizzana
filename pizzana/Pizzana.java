package pizzana;
import java.util.Scanner;
import pizzana.meals.*;
import pizzana.bills.*;
import pizzana.observers.*;
import pizzana.discounts.*;
import pizzana.payments.*;
import java.util.*;

public class Pizzana {
    private static Order currentOrder;

    public static void showAddonsMenu() {
        System.out.println("\n===== Available Add-ons =====");
        System.out.println("1. Extra Cheese (+$2.00)");
        System.out.println("2. Extra Sauce (+$1.50)");
        System.out.println("3. Extra Beetroot Jam (+$1.00)");
        System.out.println("-1. No more add-ons");
        System.out.println("==============================");
    }

    public static Meal customizeMeal(Meal baseMeal, Scanner scanner) {
        Meal customizedMeal = baseMeal;
        
        while (true) {
            showAddonsMenu();
            System.out.print("Choose add-on (or -1 to finish): ");
            int addonChoice = scanner.nextInt();
            
            if (addonChoice == -1) {
                break;
            }
            
            switch (addonChoice) {
                case 1:
                    customizedMeal = new ExtraCheese(customizedMeal);
                    System.out.println("Added Extra Cheese. Current: " + customizedMeal.getName() + " - $" + customizedMeal.getCost());
                    break;
                case 2:
                    customizedMeal = new ExtraSauce(customizedMeal);
                    System.out.println("Added Extra Sauce. Current: " + customizedMeal.getName() + " - $" + customizedMeal.getCost());
                    break;
                case 3:
                    customizedMeal = new ExtraBeetrootJam(customizedMeal);
                    System.out.println("Added Extra Beetroot Jam. Current: " + customizedMeal.getName() + " - $" + customizedMeal.getCost());
                    break;
                default:
                    System.out.println("Invalid add-on choice. Please try again.");
                    continue;
            }
            
            System.out.print("Add more extras? (yes/no): ");
            String moreExtras = scanner.next();
            if (moreExtras.equalsIgnoreCase("no")) {
                break;
            }
        }
        
        return customizedMeal;
    }

    public static void choice(IMenuFactory factory) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                Meal burger = factory.createBurger();
                System.out.println("Base: " + burger.getName() + " - $" + burger.getCost());
                Meal customizedBurger = customizeMeal(burger, scanner);
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                currentOrder.addMeal(customizedBurger, quantity);
                System.out.println("Added to order: " + customizedBurger.getName() + " x" + quantity + " - $" + customizedBurger.getCost());
                break;
            case 2:
                Meal pizza = factory.createPizza();
                System.out.println("Base: " + pizza.getName() + " - $" + pizza.getCost());
                Meal customizedPizza = customizeMeal(pizza, scanner);
                System.out.print("Enter quantity: ");
                int quantity2 = scanner.nextInt();
                currentOrder.addMeal(customizedPizza, quantity2);
                System.out.println("Added to order: " + customizedPizza.getName() + " x" + quantity2 + " - $" + customizedPizza.getCost());
                break;
            case 3:
                Meal chickenMeal = factory.createChickenMeal();
                System.out.println("Base: " + chickenMeal.getName() + " - $" + chickenMeal.getCost());
                Meal customizedChicken = customizeMeal(chickenMeal, scanner);
                System.out.print("Enter quantity: ");
                int quantity3 = scanner.nextInt();
                currentOrder.addMeal(customizedChicken, quantity3);
                System.out.println("Added to order: " + customizedChicken.getName() + " x" + quantity3 + " - $" + customizedChicken.getCost());
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrdersEventManager eventManager = new OrdersEventManager();
        OrderingSystem orderingSystem = new OrderingSystem(eventManager);
        currentOrder = orderingSystem.createOrder();
        
        // Subscribe observers
        orderingSystem.subscribe(new Kitchen());
        orderingSystem.subscribe(new Waiter());
        
        System.out.println("Welcome to Pizzana Restaurant!");
        
        boolean continueOrdering = true;
        
        while (continueOrdering) {
            // Show main menu categories
            MenuDisplaySystem menuDisplaySystem = new MenuDisplaySystem();
            menuDisplaySystem.showMainMenu();
            
            int categoryChoice = scanner.nextInt();
            IMenuFactory menuFactory;
            
            switch (categoryChoice) {
                case 1:
                    menuFactory = new KidsFactory();
                    menuDisplaySystem.showKidsMenu(menuFactory);
                    System.out.print("Choose your meal (1-3): ");
                    choice(menuFactory);
                    break;
                case 2:
                    menuFactory = new VegetarianFactory();
                    menuDisplaySystem.showVegetarianMenu(menuFactory);
                    System.out.print("Choose your meal (1-3): ");
                    choice(menuFactory);
                    break;
                case 3:
                    menuFactory = new NonVegFactory();
                    menuDisplaySystem.showNonVegMenu(menuFactory);
                    System.out.print("Choose your meal (1-3): ");
                    choice(menuFactory);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            
            System.out.println("\nDo you want to add more items from different categories? (yes/no)");
            String moreItems = scanner.next();
            if (moreItems.equalsIgnoreCase("no")) {
                continueOrdering = false;
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
        Bill bill = billingService.createBill(currentOrder);
        System.out.println(bill.toString());
        System.out.println("Please select payment method (1: Credit Card, 2: Mobile Wallet, 3: Cash): ");
        Integer paymentMethod = scanner.nextInt();
        PaymentMethod paymentStrategy = null;
        switch (paymentMethod) {
            case 1:
                System.out.print("Enter credit card number: ");
                String cardNumber = scanner.next();
                paymentStrategy = new CreditPayment(cardNumber);
                break;
            case 2:
                System.out.print("Enter mobile number: ");
                String mobileNumber = scanner.next();
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

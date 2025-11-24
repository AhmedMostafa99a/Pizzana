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

    public static void choice(IMenuFactory factory) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Meal burger = factory.createBurger();
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                currentOrder.addMeal(burger, quantity);
                System.out.println("You selected: " + burger.getName() + " - $" + burger.getCost());
                break;
            case 2:
                Meal pizza = factory.createPizza();
                System.out.print("Enter quantity: ");
                int quantity2 = scanner.nextInt();
                currentOrder.addMeal(pizza, quantity2);
                System.out.println("You selected: " + pizza.getName() + " - $" + pizza.getCost());
                break;
            case 3:
                Meal chickenMeal = factory.createChickenMeal();
                System.out.print("Enter quantity: ");
                int quantity3 = scanner.nextInt();
                currentOrder.addMeal(chickenMeal, quantity3);
                System.out.println("You selected: " + chickenMeal.getName() + " - $" + chickenMeal.getCost());
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

            // Ask if user wants to add more items
            System.out.println("\nDo you want to add more items? (yes/no)");
            String moreItems = scanner.next();
            if (moreItems.equalsIgnoreCase("no")) {
                continueOrdering = false;
            }
        }

        // Place the order
        orderingSystem.placeOrder(currentOrder);


    //    RestaurantFacade facade = new RestaurantFacade(orderingSystem, billingService, menuDisplaySystem);
       
    //    System.out.println("======hello in Pizzana!=======");
    //    ArrayList <Meal> meals = new ArrayList<>();
    //    meals.add(new BurgerStore().createMeal("Classic"));
    //    meals.add(new ItalianPizzaStore().createMeal("Italian"));
    //    meals.add(new EasternPizzaStore().createMeal("Eastern"));
        
    //    menuDisplaySystem.showMainMenu(meals);

        

        // Order order = facade.startNewOrder();


        // While adding new meals to order

extraLoop:
            while (true)
            {
                System.out.println("Do u want to add any extra (extra code or -1 for none)?");
                int extraOption = scanner.nextInt();
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
package pizzana;

import pizzana.bills.Bill;
import pizzana.bills.Order;
import pizzana.meals.Meal;
import pizzana.payments.PaymentMethod;

public class RestaurantFacade {
    private final OrderingSystem orderingSystem;
    private final BillingService billingService;
    private final MenuDisplaySystem menuDisplaySystem;

    public RestaurantFacade(OrderingSystem orderingSystem, BillingService billingService, MenuDisplaySystem menuDisplaySystem) {
        this.orderingSystem = orderingSystem;
        this.billingService = billingService;
        this.menuDisplaySystem = menuDisplaySystem;
    }

    public void displayMenu() {
        menuDisplaySystem.showMainMenu();
        menuDisplaySystem.showKidsMenu(new KidsFactory());
        menuDisplaySystem.showVegetarianMenu(new VegetarianFactory());
        menuDisplaySystem.showNonVegMenu(new NonVegFactory());
    }

   
    public Order startNewOrder() {
        return orderingSystem.createOrder();
    }

    public void addMealToOrder(Order order, Meal meal, int quantity) {
        orderingSystem.addItem(order, meal, quantity);
    }

    public void placeOrder(Order order) {
        orderingSystem.placeOrder(order);
    }

    public Bill checkoutAndPay(Order order, PaymentMethod paymentMethod) {

        Bill bill = billingService.createBill(order);
      billingService.payBill(bill, paymentMethod);
        orderingSystem.completeOrder(order);
        return bill;
    }

    public OrderingSystem getOrderingSystem() {
        return orderingSystem;
    }
}
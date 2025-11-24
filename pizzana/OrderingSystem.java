package pizzana;

import pizzana.bills.Order;
import pizzana.meals.Meal;
import pizzana.observers.OrdersEventManager;
import pizzana.observers.OrdersListener;

public class OrderingSystem {
   private final OrdersEventManager eventManager;

    public OrderingSystem(OrdersEventManager eventManager) {
       this.eventManager = eventManager;
    }

    public void subscribe(OrdersListener listener) {
       eventManager.subscribe(listener);
    }

    public Order createOrder() {
       return new Order();
    }

    public void addItem(Order order, Meal meal, int quantity) {
       order.addMeal(meal, quantity);
    }

    public void placeOrder(Order order) {
       System.out.println("\n--- Order Placed ---");
       System.out.println("Order details: " + order.getItems().length + " items");
       eventManager.notifyOrderPlaced(order);
    }

    public void completeOrder(Order order) {
       System.out.println("--- Order Completed ---");
       eventManager.notifyOrderDone(order);
    }
}

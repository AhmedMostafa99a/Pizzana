package pizzana.observers;

import pizzana.bills.Order;

public class Waiter implements OrdersListener {
    public void onOrderPlaced(Order order){
        System.out.println("Waiter got order");
    }
    public void onOrderDone(Order order){
        System.out.println("Waiter serving order");
    }
}

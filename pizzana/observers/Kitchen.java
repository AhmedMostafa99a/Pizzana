package pizzana.observers;

import pizzana.bills.Order;

public class Kitchen implements OrdersListener {
    public void onOrderPlaced(Order order){
        System.out.println("Kitchen received order");
    }
    public void onOrderDone(Order order){
        System.out.println("Kitchen completed order");
    }
}

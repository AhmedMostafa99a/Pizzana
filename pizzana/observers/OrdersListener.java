package pizzana.observers;

import pizzana.bills.Order;

public interface OrdersListener {
    void onOrderPlaced(Order order);
    void onOrderDone(Order order);
}

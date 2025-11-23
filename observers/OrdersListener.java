package pizzana.observers;

import pizzana.bills.Order;

interface OrdersListener {
    void onOrderPlaced(Order order);
    void onOrderDone(Order order);
}

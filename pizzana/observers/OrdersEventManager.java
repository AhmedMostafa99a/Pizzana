package pizzana.observers;
import java.util.ArrayList;
import java.util.Observer;

import pizzana.bills.Order;

class OrdersEventManager  {
    private ArrayList<OrdersListener> subscribers;
    void subscribe(OrdersListener listener){
        if(subscribers == null){
            subscribers = new ArrayList<>();
        }
        subscribers.add(listener);
    }
    void notifyOrderPlaced(Order order){
        if(subscribers != null){
            for(OrdersListener listener : subscribers){
                listener.onOrderPlaced(order);
            }
        }
    }
    void notifyOrderDone(Order order){
        if(subscribers != null){
            for(OrdersListener listener : subscribers){
                listener.onOrderDone(order);
            }
        }
    }
}


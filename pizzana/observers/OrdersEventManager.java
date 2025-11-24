package pizzana.observers;
import java.util.ArrayList;
import java.util.Observer;

import pizzana.bills.Order;

public class OrdersEventManager  {
    private ArrayList<OrdersListener> subscribers;
    public void subscribe(OrdersListener listener){
        if(subscribers == null){
            subscribers = new ArrayList<>();
        }
        subscribers.add(listener);
    }
    public void notifyOrderPlaced(Order order){
        if(subscribers != null){
            for(OrdersListener listener : subscribers){
                listener.onOrderPlaced(order);
            }
        }
    }
    public void notifyOrderDone(Order order){
        if(subscribers != null){
            for(OrdersListener listener : subscribers){
                listener.onOrderDone(order);
            }
        }
    }
}


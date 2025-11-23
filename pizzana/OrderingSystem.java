package pizzana;
import pizzana.bills.order;
import pizzana.meals.Meal;
public class OrderingSystem {
    // private final OrdersEventManager eventManager = new OrdersEventManager();

    public OrderingSystem() {
        
    }

    public Order createOrder() {
       return new Order();
    }

    public void addItem(Order order, Meal meal) {
       order.addItem(meal);
    }

}
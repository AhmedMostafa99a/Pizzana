package pizzana;
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

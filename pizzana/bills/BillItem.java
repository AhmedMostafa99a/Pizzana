package pizzana.bills;
import pizzana.meals.Meal;

public class BillItem {
    public OrderItem orderItem;
    public Double discount;
    public BillItem(OrderItem item, Double discount) {
        this.orderItem = item;
        this.discount = discount;
    }
}

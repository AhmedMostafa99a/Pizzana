package pizzana.discounts;

// import pizzana.bills.Order;
import pizzana.bills.OrderItem;

public interface Discount {
    double applyDiscount(OrderItem orderItem);
}

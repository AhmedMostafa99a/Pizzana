package pizzana.discounts;

import pizzana.bills.Order;
import pizzana.bills.OrderItem;

public class ChickenDiscount implements Discount {
    private static final double DISCOUNT_RATE = 0.15; // 15% discount

    @Override
    public double applyDiscount(OrderItem item) {
        if (item.meal instanceof ChickenMeal) {
            return item.getTotalPrice() * (1 - DISCOUNT_RATE);
        }
        return item.getTotalPrice() * (1 - DISCOUNT_RATE);
    }
}

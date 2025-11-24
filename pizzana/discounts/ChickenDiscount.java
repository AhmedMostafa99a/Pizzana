package pizzana.discounts;

import pizzana.bills.Order;
import pizzana.bills.OrderItem;
import pizzana.meals.ChickenMeal;

public class ChickenDiscount implements Discount {
    private static final double DISCOUNT_RATE = 0.15; // 15% discount

    @Override
    public double applyDiscount(OrderItem item) {
        if (item.meal instanceof ChickenMeal) {
            return DISCOUNT_RATE;
        }
        return 0;
    }
}

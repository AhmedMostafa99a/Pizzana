package pizzana.discounts;

import pizzana.bills.OrderItem;
import pizzana.meals.MeatMeal;

public class MeatDiscount implements Discount {
    private static final double DISCOUNT_RATE = 0.10; // 10% discount

    @Override
    public double applyDiscount(OrderItem item) {
        if (item.meal instanceof MeatMeal) {
            return item.getTotalPrice() * (1 - DISCOUNT_RATE);
        }
        return item.getTotalPrice() * (1 - DISCOUNT_RATE);
    }
}

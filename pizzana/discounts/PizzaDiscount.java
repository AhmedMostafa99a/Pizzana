package pizzana.discounts;

import pizzana.bills.OrderItem;
import pizzana.meals.PizzaMeal;

public class PizzaDiscount implements Discount {
    private static final double DISCOUNT_RATE = 0.2; // 20% discount

    @Override
    public double applyDiscount(OrderItem item) {
        if (item.meal instanceof PizzaMeal) {
            return DISCOUNT_RATE;
        }
        return 0;
    }
}

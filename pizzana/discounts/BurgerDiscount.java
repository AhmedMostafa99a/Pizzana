package pizzana.discounts;

import pizzana.bills.OrderItem;
import pizzana.meals.MeatMeal;

public class BurgerDiscount implements Discount {
    private static final double DISCOUNT_RATE = 0.30; // 30% discount

    @Override
    public double applyDiscount(OrderItem item) {
        if (item.meal instanceof MeatMeal) {
            return item.getTotalPrice() * (1 - DISCOUNT_RATE);
        }
        return item.getTotalPrice() * (1 - DISCOUNT_RATE);
}

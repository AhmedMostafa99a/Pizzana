package pizzana.discounts;

public class PizzaDiscount implements Discount {
    private static final double DISCOUNT_RATE = 0.2; // 20% discount

    @Override
    public double applyDiscount(double amount) {
        return amount * (1 - DISCOUNT_RATE);
    }
}

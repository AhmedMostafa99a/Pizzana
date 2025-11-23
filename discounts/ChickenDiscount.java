package pizzana.discounts;

public class ChickenDiscount implements Discount {
    private static final double DISCOUNT_RATE = 0.15; // 15% discount

    @Override
    public double applyDiscount(double amount) {
        return amount * (1 - DISCOUNT_RATE);
    }
}

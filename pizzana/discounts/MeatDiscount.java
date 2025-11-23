package pizzana.discounts;

public class MeatDiscount implements Discount {
    private static final double DISCOUNT_RATE = 0.10; // 10% discount

    @Override
    public double applyDiscount(double amount) {
        return amount * (1 - DISCOUNT_RATE);
    }
}

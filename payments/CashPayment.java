package pizzana.payments;

public class CashPayment implements PaymentMethod {
    private static double amount = 1000.0;
    
    public CashPayment() {
    }

    @Override
    public void pay(double totalAmount) {
        if (amount >= totalAmount) {
            double change = amount - totalAmount;
            System.out.println("Cash payment of $" + totalAmount + " processed. Change: $" + change);
        } else {
            System.out.println("Insufficient cash provided.");
            throw new IllegalArgumentException("Insufficient cash provided.");
        }
    }
}

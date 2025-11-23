package pizzana.payments;

public class CreditPayment implements PaymentMethod {
    private String cardNumber;
    private static double amount = 1000.0;
    public CreditPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double totalAmount) {
        if (amount >= totalAmount) {
            double change = amount - totalAmount;
            System.out.println("Credit payment of $" + totalAmount + " processed. Change: $" + change + " via card number: " + cardNumber);
        } else {
            System.out.println("Insufficient cash provided.");
            throw new IllegalArgumentException("Insufficient cash provided.");
        }
    }
}

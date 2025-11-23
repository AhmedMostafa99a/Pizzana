package pizzana.payments;

public class MobileWalletPayment implements PaymentMethod {
    private String mobileNumber;
    private static double amount = 1000.0;
    public MobileWalletPayment(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void pay(double totalAmount) {
        if (amount >= totalAmount) {
            double change = amount - totalAmount;
            System.out.println("Credit payment of $" + totalAmount + " processed. Change: $" + change + " via mobile number: " + mobileNumber);
        } else {
            System.out.println("Insufficient cash provided.");
            throw new IllegalArgumentException("Insufficient cash provided.");
        }
    }
}

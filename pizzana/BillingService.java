package pizzana;
import java.util.ArrayList;
import pizzana.bills.Order;
import pizzana.bills.Bill;
import pizzana.discounts.Discount;
import pizzana.payments.PaymentMethod;

public class BillingService {
    private ArrayList<Discount> discounts;
    public BillingService() {
        this.discounts = new ArrayList<>();
    }
    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }
    public Bill createBill(Order order) {
        Bill bill = new Bill(order, this.discounts.toArray(new Discount[0]));
        return bill;
    }
    public void payBill(Bill bill, PaymentMethod paymentMethod) {
        paymentMethod.pay(bill.getTotalPrice());
    }
}

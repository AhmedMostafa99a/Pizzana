package pizzana;
import pizzana.orders.Bill;
public class BillingService {

    public Bill createBill(Order order) {
        return new Bill(order);
    }
}

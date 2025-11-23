package pizzana.bills;
import pizzana.Meal;
import pizzana.discounts.Discount;

public class Bill {
    private BillItem[] billItems;

    public Bill(Order order, Discount discountStrategy) {
        OrderItem[] orderItems = order.getItems();
        this.billItems = new BillItem[orderItems.length];
        for (int i = 0; i < orderItems.length; i++) {
            OrderItem orderItem = orderItems[i];
            Double discount = discountStrategy.applyDiscount(orderItem);
            this.billItems[i] = new BillItem(orderItem, discount);
        }
    }

}

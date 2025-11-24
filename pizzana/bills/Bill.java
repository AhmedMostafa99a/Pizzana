package pizzana.bills;
import pizzana.discounts.Discount;

public class Bill {
    private BillItem[] billItems;

    public Bill(Order order, Discount[] discounts) {
        OrderItem[] orderItems = order.getItems();
        this.billItems = new BillItem[orderItems.length];

            for (int i = 0; i < orderItems.length; i++) {
                OrderItem orderItem = orderItems[i];
                Double maxDiscountsApplied = 0.0;
                for (int j = 0; j < discounts.length; j++) {
                    Double discountApplied = discounts[j].applyDiscount(orderItem);
                    if (discountApplied > maxDiscountsApplied) {
                        maxDiscountsApplied = discountApplied;
                    }
                }
                this.billItems[i] = new BillItem(orderItem, maxDiscountsApplied);
            }
    }
    public BillItem[] getBillItems() {
        return this.billItems;
    }
    public Double getTotalPrice() {
        double total = 0.0;
        for (BillItem item : billItems) {
            Double purePrice = item.orderItem.meal.getCost() * item.orderItem.quantity;
            total += (purePrice - item.discount * purePrice);
        }
        return total;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bill Details:\n");
        for (BillItem item : billItems) {
            Double purePrice = item.orderItem.meal.getCost() * item.orderItem.quantity;
            Double discountedPrice = purePrice - (item.discount * purePrice);
            sb.append(item.orderItem.meal.getName())
              .append(" x")
              .append(item.orderItem.quantity)
              .append(": ")
              .append(String.format("%.2f", discountedPrice))
              .append((item.discount > 0 ? " (Discount applied: " + String.format("%.2f", item.discount * 100) + "%)" : ""))
              .append("\n");
        }
        sb.append("Total: ").append(String.format("%.2f", getTotalPrice()));
        return sb.toString();
    }
}

package pizzana.bills;
import pizzana.meals.Meal;

public class OrderItem {
    public Meal meal;
    public Integer quantity;
    public OrderItem(Meal meal, Integer quantity) {
        this.meal = meal;
        this.quantity = quantity;
    }
    public Double getTotalPrice() {
        return this.meal.getPrice() * this.quantity;
    }
}

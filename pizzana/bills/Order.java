package pizzana.bills;
import java.util.ArrayList;

import pizzana.meals.Meal;

public class Order {
    private ArrayList<OrderItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public OrderItem[] getItems() {
        return items.toArray(new OrderItem[0]);
    }

    public void addMeal(Meal meal, Integer quantity){
        this.items.add(new OrderItem(meal, quantity));
    }
}

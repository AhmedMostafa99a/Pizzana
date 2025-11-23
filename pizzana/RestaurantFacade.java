package pizzana;
import meals.Meal;
import pizzana.bills.Bill;
import pizzana.bills.Order;

public class RestaurantFacade {
    private  OrderingSystem ordering;
    private  BillingService billing;
    private  MenuDisplaySystem menus;

    public RestaurantFacade(OrderingSystem ordering, BillingService billing, MenuDisplaySystem menus) {
        this.ordering = ordering;
        this.billing = billing;
        this.menus = menus;
    }

    public Order createOrder() {
      return ordering.createOrder()
    }

    public void addItem(Order order, Meal meal) {
       ordering.addItem(order, meal);
    }

    public Bill checkout(Order order) {
      billing.createBill(order)
    }

    public void showMenu() {
        menus.showMainMenu();
        menus.showKidsMenu(new KidsFactory());
        menus.showVegetarianMenu(new VegetarianFactory());
        menus.showNonVegMenu(new NonVegFactory());
    }

    public OrderingSystem getOrdering() {
        return ordering;
    }
}

public class BurgerStore extends MealStore {
 
    @Override
    protected Meal createBurger() {
        return new Burger("Classic Burger", 5.00);
    }
}

package pizzana;

public class ItalianPizzaStore extends MealStore {
    @Override
    protected Meal createPizza() {
        return new SimpleMeal("Italian Pizza", 8.00);
    }

}

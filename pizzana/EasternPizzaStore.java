package pizzana;
public class EasternPizzaStore extends MealStore {
    @Override
    protected Meal createPizza() {
        return new SimpleMeal("Eastern Pizza", 7.50);
    }

}

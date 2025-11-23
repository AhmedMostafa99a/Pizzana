package pizzana;

public abstract class MealDecorator implements Meal {
    protected final Meal wrappedItem;

    public MealDecorator(Meal wrappedItem) {
        this.wrappedItem = wrappedItem;
    }

    @Override
    public String getName() {
        return wrappedItem.getName();
    }

    @Override
    public double getCost() {
        return wrappedItem.getCost();
    }

    @Override
    public String toString() {
        return wrappedItem.toString();
    }
}

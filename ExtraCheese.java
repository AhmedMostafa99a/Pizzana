public class ExtraCheese extends MealDecorator {
    private final double extra = 1.50;

    public ExtraCheese(Meal wrappedItem) {
        super(wrappedItem);
    }

    @Override
    public double getCost() {
        return wrappedItem.getCost() + extra;
    }

    @Override
    public String getName() {
        return wrappedItem.getName() + " + Extra Cheese";
    }
}

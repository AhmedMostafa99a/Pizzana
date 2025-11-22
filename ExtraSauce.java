public class ExtraSauce extends MealDecorator {
    private final double extra = 0.75;

    public ExtraSauce(Meal wrappedItem) {
        super(wrappedItem);
    }

    @Override
    public double getCost() {
        return wrappedItem.getCost() + extra;
    }

    @Override
    public String getName() {
        return wrappedItem.getName() + " + Extra Sauce";
    }
}

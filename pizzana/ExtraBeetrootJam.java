package pizzana;

import pizzana.meals.Meal;

public class ExtraBeetrootJam extends MealDecorator {
    private final double extra = 0.90;

    public ExtraBeetrootJam(Meal wrappedItem) {
        super(wrappedItem);
    }

    @Override
    public double getCost() {
        return wrappedItem.getCost() + extra;
    }

    @Override
    public String getName() {
        return wrappedItem.getName() + " + Extra Beetroot Jam";
    }
}

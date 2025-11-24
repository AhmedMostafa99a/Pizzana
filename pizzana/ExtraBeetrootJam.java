package pizzana;

import pizzana.meals.Meal;

public class ExtraBeetrootJam extends MealDecorator {
    private static final double COST = 2.0;

    public ExtraBeetrootJam(Meal decoratedMeal) {
        super(decoratedMeal);
    }

    @Override
    public double getCost() {
        return super.getCost() + COST;
    }

    @Override
    public String getName() {
        return super.getName() + " + Extra Beetroot Jam";
    }
}
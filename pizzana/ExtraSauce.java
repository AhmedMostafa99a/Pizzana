package pizzana;

import pizzana.meals.Meal;

public class ExtraSauce extends MealDecorator {
    private static final double COST = 0.75;

    public ExtraSauce(Meal decoratedMeal) {
        super(decoratedMeal);
    }

    @Override
    public double getCost() {
        return super.getCost() + COST;
    }

    @Override
    public String getName() {
        return super.getName() + " + Extra Sauce";
    }
}
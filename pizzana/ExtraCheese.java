package pizzana;

import pizzana.meals.Meal;

public class ExtraCheese extends MealDecorator {
    private static final double COST = 1.50;

    public ExtraCheese(Meal decoratedMeal) {
        super(decoratedMeal);
    }

    @Override
    public double getCost() {
        return super.getCost() + COST;
    }

    @Override
    public String getName() {
        return super.getName() + " + Extra Cheese";
    }
}
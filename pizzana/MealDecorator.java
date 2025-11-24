package pizzana;

import pizzana.meals.Meal;

public abstract class MealDecorator implements Meal {
 protected Meal decoratedMeal;

    public MealDecorator(Meal decoratedMeal) {
        this.decoratedMeal = decoratedMeal;
    }

    @Override
    public double getCost() {
        return decoratedMeal.getCost();
    }

    @Override
    public String getName() {
        return decoratedMeal.getName();
    }
}

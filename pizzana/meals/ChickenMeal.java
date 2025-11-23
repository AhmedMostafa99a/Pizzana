package pizzana.meals;

public class ChickenMeal implements Meal {
    private final String name;
    private final double cost;

    public ChickenMeal(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + cost + ")";
    }
}

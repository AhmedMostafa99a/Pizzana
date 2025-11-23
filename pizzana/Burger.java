package pizzana;

public class Burger implements Meal {
    private final String name;
    private final double baseCost;

    public Burger(String name, double baseCost) {
        this.name = name;
        this.baseCost = baseCost;
    }

    @Override
    public double getCost() {
        return baseCost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + baseCost + ")";
    }
}

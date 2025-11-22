public class NonVegFactory implements IMenuFactory {
    @Override
    public Meal createAppetizer() {
        return new SimpleMeal("Chicken Wings", 3.00);
    }

    @Override
    public Meal createMainCourse() {
        return new SimpleMeal("Grilled Chicken", 8.50);
    }

    @Override
    public Meal createSalad() {
        return new SimpleMeal("Caesar Salad", 3.50);
    }
}

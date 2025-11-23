package pizzana;
 abstract class MealStore {
  
    public Meal orderPizza() {
        Meal pizza = createPizza();
        System.out.println("Preparing " + pizza.getName() + " with cost $" + pizza.getCost());
        return pizza;
    }

    public Meal orderBurger() {
        Meal burger = createBurger();
        System.out.println("Preparing " + burger.getName() + " with cost $" + burger.getCost());
        return burger;
    }

    protected Meal createPizza() {
        throw new UnsupportedOperationException("This store does not create pizzas");
    }
    protected Meal createBurger() {
        throw new UnsupportedOperationException("This store does not create burgers");
    }
}
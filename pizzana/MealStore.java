package pizzana;

import pizzana.meals.Meal;

abstract class MealStore {
  
    public Meal orderPizza(String type, double cost) {
        Meal pizza = createPizza(type, cost);
        System.out.println("Preparing " + pizza.getName() + " with cost $" + pizza.getCost());
        return pizza;
    }

    public Meal orderBurger(String type, double cost) {
        Meal burger = createBurger(type, cost);
        System.out.println("Preparing " + burger.getName() + " with cost $" + burger.getCost());
        return burger;
    }

    protected Meal createPizza(String type, double cost) {
        throw new UnsupportedOperationException("This store does not create pizzas");
    }
    protected Meal createBurger(String type, double cost) {
        throw new UnsupportedOperationException("This store does not create burgers");
    }
}
package pizzana;
public interface IMenuFactory {
    Meal createAppetizer();
    Meal createMainCourse();
    Meal createSalad();
}
package book.chap4.model;

import java.util.Arrays;
import java.util.List;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isVegetarian() {
        return this.vegetarian;
    }

    public int getCalories() {
        return this.calories;
    }

    public Type getType() {
        return this.type;
    }

    public enum Type { MEAT, FISH, OTHER }

    public static List<Dish> getMenu() {
        return Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish ("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 300, Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
        );
    }

    public CaloricLevel getCaloricLevel() {
        if (getCalories() <= 400) return CaloricLevel.DIET;
        else if (this.getCalories() <= 700) return CaloricLevel.NORMAL;
        else return CaloricLevel.FAT;
    }
}

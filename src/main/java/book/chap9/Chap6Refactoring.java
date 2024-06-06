package book.chap9;

import book.chap4.model.CaloricLevel;
import book.chap4.model.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Chap6Refactoring {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();
        Map<CaloricLevel, List<Dish>> dishByCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getCaloricLevel)
        );

//        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        int totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();

        System.out.println(dishByCaloricLevel);
        System.out.println(totalCalories);
    }
}

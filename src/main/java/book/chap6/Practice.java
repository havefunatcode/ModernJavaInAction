package book.chap6;

import book.chap4.model.Dish;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class Practice {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();

        Map<Dish.Type, List<Dish>> caloricDishesByType1 = menu.stream()
                .filter(dish -> dish.getCalories() > 500)
                .collect(groupingBy(Dish::getType));

        Map<Dish.Type, List<Dish>> caloricDishesByType2 = menu.stream()
                .collect(
                        groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList()))
                );

        Map<Dish.Type, List<String>> dishNamesByType = menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        System.out.println(caloricDishesByType1);
        System.out.println(caloricDishesByType2);
        System.out.println(dishNamesByType);
    }
}

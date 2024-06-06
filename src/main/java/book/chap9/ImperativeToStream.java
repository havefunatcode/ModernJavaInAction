package book.chap9;

import book.chap4.model.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImperativeToStream {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();
        List<String> dishNames = new ArrayList<>();

        for (Dish dish : menu) {
            if (dish.getCalories() > 300) {
                dishNames.add(dish.getName());
            }
        }

        List<String> dishNamesAbove300 = menu.stream().filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(dishNamesAbove300);
    }
}

package book.chap6;

import book.chap4.model.Dish;

import java.util.IntSummaryStatistics;
import java.util.List;

import static java.util.stream.Collectors.summarizingInt;

public class ReducePartOne {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();
        IntSummaryStatistics collect = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(collect);
    }
}

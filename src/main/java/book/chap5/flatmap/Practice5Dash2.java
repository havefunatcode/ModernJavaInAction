package book.chap5.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice5Dash2 {
    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    public static void main(String[] args) {
        thirdQuestion();
    }

    private static void firstQuestion() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result = numbers.stream().map(num -> num * num).collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    private static void secondQuestion() {
        List<List<Integer>> result = numbers1.stream()
                .flatMap(number1 -> numbers2.stream().map(number2 -> Arrays.asList(number1, number2)))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    private static void thirdQuestion() {
        List<List<Integer>> result = numbers1.stream()
                .flatMap(number1 ->
                        numbers2.stream()
                                .filter(number2 -> (number1 + number2) % 3 == 0)
                                .map(number2 -> Arrays.asList(number1, number2))
                )
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}

package modern.java.book.chap5.model;

import java.util.stream.Stream;

public class Quiz {
    public static void main(String[] args) {
        fibonacci();
    }

    private static void fibonacci() {
        Stream.iterate(new int[] {0, 1}, numbers -> new int[] {numbers[1], numbers[0] + numbers[1]})
                .limit(20)
                .forEach(element -> System.out.println("(" + element[0] + ", " + element[1] + ")"));
    }

}

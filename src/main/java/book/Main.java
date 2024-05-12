package book;

import book.chap2.apple.formatter.AppleFancyFormatter;
import book.chap2.apple.formatter.AppleSimpleFormatter;
import book.chap2.apple.model.Apple;
import book.chap2.apple.formatter.AppleFormatter;
import book.chap2.apple.model.AppleColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static book.chap2.apple.model.AppleColor.*;

public class Main {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
            new Apple(150, GREEN),
            new Apple(200, RED),
            new Apple(30, BLUE)
        );

        prettyPrintApple(inventory, new AppleFancyFormatter());
        System.out.println("====================================");
        prettyPrintApple(inventory, new AppleSimpleFormatter());
    }

    private static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (Apple apple: inventory) {
            String output = appleFormatter.accept(apple);
            System.out.println(output);
        }
    }

}
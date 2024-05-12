package book.chap2.apple.formatter;

import book.chap2.apple.model.Apple;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String measure = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + measure + " " + apple.getColor() + " apple";
    }

}

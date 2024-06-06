package book.chap9.design_pattern.strategy;

public class StrategyMain {
    public static void main(String[] args) {
//        Validator numericValidator = new Validator(new IsNumeric());
//        numericValidator.validate("aaaa");
//        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
//        lowerCaseValidator.validate("bbb");

        Validator numericValidator = new Validator((String s) -> s.matches("[a-z]+"));
        numericValidator.validate("aaa");
        Validator lowerCaseValidator = new Validator((String s) -> s.matches("\\d+"));
        lowerCaseValidator.validate("bbb");
    }
}

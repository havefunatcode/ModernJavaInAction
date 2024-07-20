package book.chap13.rule.diamond_problem;

public interface C extends A{
    @Override
    default void hello() {
        A.super.hello();
    }
}

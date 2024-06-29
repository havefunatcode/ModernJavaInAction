package book.chap13.rule.diamond_problem;

public interface A {
    default void hello() {
        System.out.println("Hello from B");
    }
}

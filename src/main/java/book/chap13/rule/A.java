package book.chap13.rule;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

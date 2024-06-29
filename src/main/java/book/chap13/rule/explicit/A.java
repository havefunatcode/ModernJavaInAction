package book.chap13.rule.explicit;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

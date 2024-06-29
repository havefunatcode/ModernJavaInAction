package book.chap13.rule.explicit;

public interface B {
    default void hello() {
        System.out.println("Hello from B");
    }
}

package book.chap9.design_pattern.observer;

@FunctionalInterface
public interface Observer {
    void notify(String tweet);
}

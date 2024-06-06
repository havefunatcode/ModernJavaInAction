package book.chap9;

public class DoTask {
    public static void doSomething(Runnable r) { r.run(); }
    public static void doSomething(Task a) { a.execute(); }
}

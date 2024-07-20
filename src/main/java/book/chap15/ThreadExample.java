package book.chap15;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException{
        int x = 1337;
        Result result = new Result();

        Thread t1 = new Thread(() -> {
            result.setLeft(f(x));
        });
        Thread t2 = new Thread(() -> {
            result.setRight(g(x));
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(result.getLeft() + result.getRight());
    }

    private static int f(int x) {
        return x;
    }

    private static int g(int y) {
        return y;
    }

}

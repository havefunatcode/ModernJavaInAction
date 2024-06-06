package book.chap9;

public class Chap9Main {
    public static void main(String[] args) {
//        runnableLambda();
        doSomething();
    }

    private static void runnableLambda() {
        int a = 10;

        Runnable r1 = () -> {
            System.out.println(a);
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };
    }

    private static void doSomething() {
        DoTask.doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger danger!!");
            }
        });

        DoTask.doSomething((Task)() -> System.out.println("Danger danger!!"));
    }
}

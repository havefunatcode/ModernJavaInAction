package book.chap9;

public class AnonymousToLambda {
    public static void main(String[] args) {
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
}

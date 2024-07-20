package book.chap15;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 1337;

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> fResult = executorService.submit(() -> f(x));
        Future<Integer> gResult = executorService.submit(() -> g(x));
        System.out.println(fResult.get() + gResult.get());

        executorService.shutdown();
    }

    private static int f(int x) {
        return x;
    }

    private static int g(int y) {
        return y;
    }
}

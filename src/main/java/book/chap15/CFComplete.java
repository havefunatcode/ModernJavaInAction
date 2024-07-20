package book.chap15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFComplete {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int x = 1337;

        CompletableFuture<Integer> integerCompletableFuture = new CompletableFuture<>();
        executorService.submit(() -> integerCompletableFuture.complete(f(x)));
        int b = g(x);
        System.out.println(integerCompletableFuture.get() + b);

        executorService.shutdown();
    }

    private static int f(int x) {
        return 0;
    }
    private static int g(int x) {
        return 0;
    }
}

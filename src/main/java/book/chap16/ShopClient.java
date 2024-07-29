package book.chap16;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShopClient {
    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        doSomethingElse();

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + "msecs");
    }

    private static List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll")
    );

    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPriceAsync(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesWithParallelStream(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPriceAsync(product)))
                .collect(Collectors.toList());
    }

    public List<CompletableFuture<String>> findPricesWithCompletableFutureV1(String product) {
        return shops.stream().map(shop ->
                CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPriceAsync(product)))
        ).collect(Collectors.toList());
    }

    public List<String> findPricesWithCompletableFutureV2(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPriceAsync(product)))
                ).collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    });

    public List<String> findDiscountPrices(String product) {
        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public List<String> findDiscountPricesWithCompletableFuture(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(
                        quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor))
                ).collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public void combineUniqueCompletableFutures(Shop shop, String product) {
        Future<Double> futurePriceInUSD = CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> exchangeService.getRate(Money.EUR, Money.USD)),
                        (price, rate) -> price * rate
                ));
    }

    public void orTimeoutExample(Shop shop, String product) {
        CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                .thenCombine(
                        CompletableFuture.supplyAsync(
                                () -> exchangeService.getRate(Money.EUR, Money.USD)
                        ),(price, rate) -> price * rate
                ).orTimeout(3, TimeUnit.SECONDS);
    }

    public void completeOnTimeoutExample(Shop shop, String product) {
        CompletableFuture.supplyAsync(() -> shop.getPrice(product))
            .thenCombine(
                CompletableFuture.supplyAsync(
                        () -> exchangeService.getRate(Money.EUR, Money.USD))
                        .completeOnTimeout(DEFAULT_RATE, 1, TimeUnit.SECONDS),
                (price, rate) -> price * rate
            ).orTimeout(3, TimeUnit.SECONDS);
    }

    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(
                        quote -> CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), executor
                        )
                ));
    }

    public void responseToCompletableFuture() {
        CompletableFuture[] futures = findPricesStream("myPhone")
                .map(future -> future.thenAccept(System.out::println))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        CompletableFuture.anyOf(futures).join();
    }
}

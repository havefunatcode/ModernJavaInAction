package book.chap16;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static book.chap16.Util.delay;

public class Shop {
    private String name;

  public String getName() {
    return name;
  }

  public Shop(String name) {
        this.name = name;
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    public String getPrice(String product) {
      double price = calculatePrice(product);
      Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
      return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

}

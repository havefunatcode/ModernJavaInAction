package book.chap16;

public class Quote {
    private final String shopname;
    private final double price;
    private final Discount.Code discountCode;

    public Quote(String shopname, double price, Discount.Code discountCode) {
        this.shopname = shopname;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }

    public String getShopname() {
        return shopname;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}

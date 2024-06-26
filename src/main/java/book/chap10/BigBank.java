package book.chap10;

import book.chap10.composite.CompositeBuilder;
import book.chap10.func_sequencing.LambdaOrderBuilder;
import book.chap10.model.Order;
import book.chap10.model.Stock;
import book.chap10.model.Trade;
import book.chap10.nested_func.NestedFunctionOrderBuilder;

import static book.chap10.method_chain.MethodChainingOrderBuilder.forCustomer;
import static book.chap10.nested_func.NestedFunctionOrderBuilder.*;

public class BigBank {
    public static void main(String[] args) {
        Order order = new Order();
        order.setCustomer("BigBank");

        Trade trade1 = new Trade();
        trade1.setType(Trade.Type.BUY);

        Stock stock1 = new Stock();
        stock1.setSymbol("IBM");
        stock1.setMarket("NYSE");

        trade1.setStock(stock1);
        trade1.setPrice(125.00);
        trade1.setQuantity(80);
        order.addTrade(trade1);

        Trade trade2 = new Trade();
        trade2.setType(Trade.Type.BUY);

        Stock stock2 = new Stock();
        stock2.setSymbol("GOOGLE");
        stock2.setMarket("NASDAQ");

        trade2.setStock(stock2);
        trade2.setPrice(375.00);
        trade2.setQuantity(50);
        order.addTrade(trade2);
    }

    private static void methodChain() {
        Order order = forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)
                .sell(50)
                .stock("GOOGLE")
                .on("NASDAQ")
                .at(375.00)
                .end();
    }

    private static void nestedFunc() {
        Order order = NestedFunctionOrderBuilder.order(
                "BingBank",
                buy(80, stock("IBM", on("NYSE")), at(125.00)),
                sell(50, stock("GOOGLE", on("NASDAQ")), at(375.00))
        );
    }

    private static void funcSequencing() {
        Order order = LambdaOrderBuilder.order(o -> {
            o.forCustomer("BigBank");
            o.buy(t -> {
                t.quantity(80);
                t.price(125.00);
                t.stock(s -> {
                    s.symbol("IBM");
                    s.market("NYSE");
                });
            });

            o.sell(t -> {
                t.quantity(50);
                t.price(375.00);
                t.stock(s -> {
                    s.symbol("GOOGLE");
                    s.market("NASDAQ");
                });
            });
        });
    }

    private static void composite() {
//        Order order = CompositeBuilder.forCustomer(
//                "BigBank",
//                buy(t -> t.quantity(80)
//                        .stock("IBM")
//                        .on("NYSE")
//                        .at(125.00)),
//                sell(t -> t.quantity(50)
//                        .stock("GOOGLE")
//                        .on("NASDAQ")
//                        .at(125.00))
//                );
    }

}

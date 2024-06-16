package book.chap10.method_reference;

import book.chap10.model.Order;

import java.util.function.DoubleUnaryOperator;

public class TaxCalculatorFluent {
    public DoubleUnaryOperator taxFunction = d -> d;

    public TaxCalculatorFluent with(DoubleUnaryOperator f) {
        taxFunction = taxFunction.andThen(f);
        return this;
    }

    public double calculate(Order order) {
        return taxFunction.applyAsDouble(order.getValue());
    }
}
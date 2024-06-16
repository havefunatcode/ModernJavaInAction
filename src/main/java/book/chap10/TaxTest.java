package book.chap10;

import book.chap10.method_reference.TaxCalculatorFixed;
import book.chap10.method_reference.TaxCalculatorFluent;
import book.chap10.model.Order;
import book.chap10.model.Tax;

public class TaxTest {
    public static void main(String[] args) {

    }

    private static void calculateWithFixed(Order order) {
        TaxCalculatorFixed taxCalculatorFixed = new TaxCalculatorFixed();
        taxCalculatorFixed.withTaxRegional()
                .withTaxSurcharge()
                .calculate(order);
    }

    private static void calculateWithFluent(Order order) {
        TaxCalculatorFluent taxCalculatorFluent = new TaxCalculatorFluent();
        taxCalculatorFluent.with(Tax::regional)
                .with(Tax::surcharge)
                .calculate(order);
    }
}

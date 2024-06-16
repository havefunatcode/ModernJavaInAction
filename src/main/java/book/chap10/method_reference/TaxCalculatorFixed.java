package book.chap10.method_reference;

import book.chap10.model.Order;
import book.chap10.model.Tax;

public class TaxCalculatorFixed {
    private boolean useReginal;
    private boolean useGeneral;
    private boolean useSurcharge;

    public TaxCalculatorFixed withTaxRegional() {
        useReginal = true;
        return this;
    }

    public TaxCalculatorFixed withTaxGeneral() {
        useGeneral = true;
        return this;
    }

    public TaxCalculatorFixed withTaxSurcharge() {
        useSurcharge = true;
        return this;
    }

    public double calculate(Order order) {
        return calculate(order, useReginal, useGeneral, useSurcharge);
    }

    private static double calculate(Order order, boolean useRegional, boolean useGeneral, boolean useSurcharge) {
        double value = order.getValue();
        if (useRegional) value = Tax.regional(value);
        if (useGeneral) value = Tax.general(value);
        if (useSurcharge) value = Tax.surcharge(value);
        return value;
    }

}

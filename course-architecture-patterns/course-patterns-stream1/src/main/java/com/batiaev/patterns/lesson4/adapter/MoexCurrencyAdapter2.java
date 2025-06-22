package com.batiaev.patterns.lesson4.adapter;

import java.math.BigDecimal;

public class MoexCurrencyAdapter2 extends MoexCurrency implements Currency {
    @Override
    public String getName() {
        return getIsin();
    }

    @Override
    public BigDecimal getQuote() {
        return BigDecimal.valueOf(getValue() / getQuoteDecimal());
    }
}

package com.batiaev.patterns.lesson4.adapter;

import java.math.BigDecimal;

public class MoexCurrencyAdapter implements Currency {
    private MoexCurrency currency;

    public MoexCurrencyAdapter(MoexCurrency currency) {
        this.currency = currency;
    }

    @Override
    public String getName() {
        return currency.getIsin();
    }

    @Override
    public BigDecimal getQuote() {
        return BigDecimal.valueOf(currency.getValue() / currency.getQuoteDecimal());
    }
}

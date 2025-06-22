package com.batiaev.patterns.lesson4.composite;

import lombok.Data;

@Data
public class Option extends Derivative {
    private FinancialInstrument underlying;

    public Option(Futures futures) {
        this.underlying = futures;
    }

    @Override
    public double getQuote() {
        return underlying.getQuote();
    }
}

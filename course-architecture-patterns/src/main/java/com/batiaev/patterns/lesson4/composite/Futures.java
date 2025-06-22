package com.batiaev.patterns.lesson4.composite;

import lombok.Data;

@Data
public class Futures extends Derivative {
    private FinancialInstrument underlying;
    private long lot;

    public Futures(StockAsset stockAsset) {
        this.underlying = stockAsset;
    }

    @Override
    public double getQuote() {
        return underlying.getQuote() * lot;
    }
}

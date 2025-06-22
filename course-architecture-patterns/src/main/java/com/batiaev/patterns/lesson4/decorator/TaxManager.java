package com.batiaev.patterns.lesson4.decorator;

public class TaxManager implements TransactionDecorator {
    void calculateTaxes(String accountId) {
        //FIXME
    }

    @Override
    public void process(String accountId) {
        calculateTaxes(accountId);
    }
}

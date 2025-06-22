package com.batiaev.patterns.lesson4.proxy;

public class CentalBankQuotationManager implements QuotationManager {

    @Override
    public double getQuote() {
        return loadQuoteFromRestApi();
    }

    private double loadQuoteFromRestApi() {
        //FIXME
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 42;
    }
}

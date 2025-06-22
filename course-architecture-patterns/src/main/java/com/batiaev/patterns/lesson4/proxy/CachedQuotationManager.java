package com.batiaev.patterns.lesson4.proxy;

public class CachedQuotationManager implements QuotationManager {
    private final QuotationManager quotationManager;
    private double quote = 0d;

    public CachedQuotationManager(QuotationManager quotationManager) {
        this.quotationManager = quotationManager;
    }

    public void fetchData() {
        quote = quotationManager.getQuote();
    }

    @Override
    public double getQuote() {
        return quote;
    }
}

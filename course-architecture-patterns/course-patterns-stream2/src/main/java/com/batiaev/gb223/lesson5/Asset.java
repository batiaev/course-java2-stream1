package com.batiaev.gb223.lesson5;

/**
 * Asset
 *
 * @author anton
 * @since 30/07/19
 */
public class Asset {
    private Quote quote;
    private long amount;

    public double getValue() {
        return quote.get() * amount;
    }
}

package com.batiaev.java3.lesson1;

public class Quotes implements Event {
    private double quote;

    public Quotes(double quote) {
        this.quote = quote;
    }

    @Override
    public double getData() {
        return 0;
    }

    @Override
    public double getKey() {
        return 0;
    }
}

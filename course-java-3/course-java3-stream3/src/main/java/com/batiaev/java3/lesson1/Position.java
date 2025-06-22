package com.batiaev.java3.lesson1;

public class Position implements Event {
    private double position;
    private String ticker;

    public Position(double quote) {
        this.position = quote;
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

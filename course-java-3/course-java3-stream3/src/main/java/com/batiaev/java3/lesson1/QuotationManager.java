package com.batiaev.java3.lesson1;

import java.util.Random;

public class QuotationManager {
    private Listener<Quotes> quotesListener = new Listener<>();
    private Listener<Position> positionListener = new Listener<>();

    private void generator() {
        double v = new Random().nextDouble();

        quotesListener.onEvent(new Quotes(v));
        positionListener.onEvent(new Position(v));
    }
}

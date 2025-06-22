package com.batiaev.patterns.lesson4.bridge;

public class NyseCurrency extends Currency implements NyseAssets {

    @Override
    public String nyseTicker() {
        return null;
    }
}

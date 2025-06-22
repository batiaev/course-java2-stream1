package com.batiaev.patterns.lesson4.bridge;

public class MoexStock extends Stock implements MoexAssets {
    @Override
    public String getMoexTicker() {
        return null;
    }
}

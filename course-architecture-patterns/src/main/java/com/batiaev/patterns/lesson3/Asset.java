package com.batiaev.patterns.lesson3;

import lombok.Data;

@Data
public class Asset {
    private String name;
    private double amount;

    public Asset(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
}

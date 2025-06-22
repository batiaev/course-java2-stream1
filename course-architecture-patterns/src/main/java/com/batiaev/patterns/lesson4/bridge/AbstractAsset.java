package com.batiaev.patterns.lesson4.bridge;

import lombok.Data;

@Data
public abstract class AbstractAsset {
    private String name;
    private long lot;
    private double quote;
}

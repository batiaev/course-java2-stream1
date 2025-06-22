package com.batiaev.patterns.lesson4.bridge;

import lombok.Data;

@Data
public class Stock extends AbstractAsset {
    private String isin;
}

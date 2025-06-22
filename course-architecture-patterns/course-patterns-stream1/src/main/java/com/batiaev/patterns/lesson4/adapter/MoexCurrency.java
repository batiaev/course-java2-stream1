package com.batiaev.patterns.lesson4.adapter;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MoexCurrency {
    private long localCurId;
    private String isin;
    private long value;
    private long quoteDecimal;
}

package com.batiaev.patterns.lesson6;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class Money {
    private BigDecimal amount;
    private Currency currency;
}

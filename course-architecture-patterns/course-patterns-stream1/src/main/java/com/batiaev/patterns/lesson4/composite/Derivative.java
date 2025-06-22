package com.batiaev.patterns.lesson4.composite;

public abstract class Derivative extends FinancialInstrument {
    abstract FinancialInstrument getUnderlying();
}

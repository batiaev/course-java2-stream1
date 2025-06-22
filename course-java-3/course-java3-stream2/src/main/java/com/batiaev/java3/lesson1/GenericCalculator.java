package com.batiaev.java3.lesson1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericCalculator<T extends Number
        & Serializable & Comparable<T>> {
    private T value;

    public GenericCalculator(T arg) {
        value = arg;
    }

    public double summa(T value) {
        return this.value.doubleValue() + value.doubleValue();
    }

    public T max(T value) {
        return this.value.compareTo(value) > 0 ? this.value : value;
    }

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();

        GenericCalculator<Long> calculator = new GenericCalculator<>(15L);

//        calculator.summa(16.7);
//        Long summa = calculator.summa(16L);

    }
}

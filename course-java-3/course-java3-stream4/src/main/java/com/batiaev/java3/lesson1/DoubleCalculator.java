package com.batiaev.java3.lesson1;

/**
 * DoubleCalculator
 *
 * @author anton
 * @since 19/08/19
 */
public class DoubleCalculator extends Calculator<Double> {
    public static void main(String[] args) {
        Processor doubleCalculator = new DoubleCalculator();
        int process = doubleCalculator.process(3.14, 7.45);
    }

    @Override
    public int process(Double v1, Double v2) {
        return sum(v1, v2);
    }

    @Override
    public int sum(Double v1, Double v2) {
        double v = v1 + v2;
        return (int) v;
    }
}

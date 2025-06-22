package com.batiaev.java3.lesson1;

/**
 * Calculator
 *
 * @author anton
 * @since 19/08/19
 */
public class Calculator<T extends Number> implements Processor<T> {

    @Override
    public int process(T v1, T v2) {
        return sum(v1, v2);
    }

    public int sum(T v1, T v2) {
        return v1.intValue() + v2.intValue();
    }

    public static void main(String[] args) {
        //example1
        Calculator<Integer> integerCalculator = new Calculator<>();
        int v1 = 5;
        int v2 = 37;
        int result = integerCalculator.sum(v1, v2);
        System.out.println("Result = " + result);

        //example2
        Calculator<Long> longCalculator = new Calculator<>();
        long v21 = 7L;
        long v11 = 1L;
        int sum = longCalculator.sum(v11, v21);
        System.out.println("Long result = " + sum);

        //example3
        Processor<Long> longProcessor = new Calculator<>();
        int process = longProcessor.process(1L, 2L);
    }
}

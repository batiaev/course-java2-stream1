package com.batiaev.java2.lesson5.homework;

import java.util.Arrays;

/**
 * Calculator
 *
 * @author anton
 * @since 01/11/17
 */
public class Calculator {

    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args) {
        plainCalc();
        twoThreadCalc();
        streamCalc();
        parallelStreamCalc();
    }

    private static void plainCalc() {
        double[] arr = new double[size];
        Arrays.fill(arr, 1);
        System.out.format("Test #1 : %5s%n", calcArr(arr));
    }

    private static void twoThreadCalc() {
        double[] arr = new double[size];
        double[] a1 = new double[h];
        double[] a2 = new double[h];
        Arrays.fill(arr, 1);

        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        final long[] calcTimes = new long[5];

        calcTimes[0] = System.currentTimeMillis() - start;

        Thread th = new Thread(() -> calcTimes[1] = calcArr(a1));
        th.start();
        calcTimes[2] = calcArr(a2);
        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long joinTime = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        calcTimes[3] = System.currentTimeMillis() - joinTime;
        calcTimes[4] = System.currentTimeMillis() - start;

        System.out.format("Test #2 : %5s ~= %s + max(%s, %s) + %s%n",
                calcTimes[4], calcTimes[0], calcTimes[1], calcTimes[2], calcTimes[3]);
    }

    private static void streamCalc() {
        double[] arr = new double[size];
        Arrays.fill(arr, 1);
        final int[] idx = {0};
        long start = System.currentTimeMillis();
        Arrays.stream(arr).forEach(value -> calcItem(idx[0]++, value));
        System.out.format("Test #3 : %5s%n",
                System.currentTimeMillis() - start);
    }

    private static void parallelStreamCalc() {
        double[] arr = new double[size];
        Arrays.fill(arr, 1);
        final int[] idx = {0};
        long start = System.currentTimeMillis();
        Arrays.stream(arr).parallel().forEach(value -> calcItem(idx[0]++, value));
        System.out.format("Test #4 : %5s%n", System.currentTimeMillis() - start);
    }

    private static long calcArr(double[] m) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < m.length; i++) {
            m[i] = calcItem(i, m[i]);
        }
        return System.currentTimeMillis() - start;
    }

    private static double calcItem(int index, double value) {
        return value * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2);
    }
}

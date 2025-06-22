package com.batiaev.java2.lesson5;

import java.util.Arrays;

public class Homework {
    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;

    private static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        fill();
        System.out.println(single());
        fill();
        System.out.println(concurrent());
    }

    private static void fill() {
        Arrays.fill(arr, 1);
    }

    private static long single() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = calculate(i, arr[i]);
        }
        long b = System.currentTimeMillis();
        return (b - a);
    }

    private static float calculate(int i, float val) {
        return (float) (val * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    private static long concurrent() {
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = calculate(i, a1[i]);
            }
            System.arraycopy(a1, 0, arr, 0, HALF);
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = calculate(i + HALF, a2[i]);
            }
            System.arraycopy(a2, 0, arr, HALF, HALF);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long b = System.currentTimeMillis();
        return (b - a);
    }
}

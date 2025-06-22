package com.batiaev.java1.lesson2;

import java.util.Arrays;

/**
 * Homework
 *
 * @author anton
 * @since 09/12/17
 */
public class Homework {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(data));
        task7(data, -13);
        System.out.println(Arrays.toString(data));
    }

    private static void task7(int[] data, int shift) {
        shift = shift % data.length;
        if (shift < 0) shift = data.length + shift;

        for (int i = 0; i < shift; ++i) {
            int firstVal = data[0];
            for (int j = 1; j < data.length; ++j) {
                data[j - 1] = data[j];
            }
            data[data.length - 1] = firstVal;
        }

    }

    private static boolean task6() {

        int[] data = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int leftSum = 0;
        int rightSum = 0;
        for (int aData : data) rightSum += aData;

        for (int val : data) {
            leftSum += val;
            rightSum -= val;
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    private static void task5() {
        int[] data = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        int max = data[0];
        int min = data[0];
        for (int i = 0; i < data.length; ++i) {
            if (min > data[i]) min = data[i];
            if (max < data[i]) max = data[i];
        }
        System.out.println("Max = " + max + ", and min = " + min);
    }


    private static void task3() {
        int[] data = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < data.length; ++i) {
            if (data[i] < 6) data[i] *= 2;
        }
    }

    private static void task4() {
        int size = 5;
        int[][] data = new int[size][size];
        for (int i = 0; i < size; ++i) {
            data[i][i] = 1;
            data[i][size - i - 1] = 1;
        }

        for (int i = 0; i < size; ++i) {
            System.out.println(Arrays.toString(data[i]));
        }
    }

    private static void task2() {
        int[] data = new int[8];
        System.out.println(Arrays.toString(data));
        for (int i = 0; i < data.length; ++i) {
            data[i] = i * 3;
        }
        System.out.println(Arrays.toString(data));
    }

    private static void task1() {
        int[] data = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(data));
        for (int i = 0; i < data.length; ++i) {
            data[i] = data[i] == 1 ? 0 : 1;
        }
        System.out.println(Arrays.toString(data));
    }
}

package com.batiaev.java3.lesson6;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Homework6 {
    public static int[] task2(int[] arrIn) {
        int[] backArr = new int[2];
        if (arrIn.length == 0) {
            log.info("В массиве нет элементов");
            return arrIn;
        }
        for (int i = arrIn.length - 3; i >= 0; i--) {
            if (arrIn[i] == 4) {
                System.arraycopy(arrIn, (i + 1), backArr, 0, 2);
                return backArr;
            }
        }
        throw new RuntimeException("В массиве нет ни одной четверки, после которой есть два числа");
    }

    public static boolean task3(int[] arrIn) {
        boolean one = false;
        boolean four = false;
        for (int i : arrIn) {
            if (i != 1 && i != 4) throw new RuntimeException("invalid value");
            if (i == 1) one = true;
            if (i == 4) four = true;
        }
        return (one && four);
    }
}

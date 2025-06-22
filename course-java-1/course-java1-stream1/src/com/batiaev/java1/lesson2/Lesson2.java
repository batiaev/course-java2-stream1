package com.batiaev.java1.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lesson2
 *
 * @author anton
 * @since 04/12/17
 */
public class Lesson2 {

//    public static void main(String[] args) {
//        test1();
//    }

    private static void test1() {
        int[][] data = new int[5][];
        int row = 1;
        data[row] = new int[6];
        data[1] = new int[3];
        data[2] = new int[8];
        data[3] = new int[15];

        data[1][0] = 2;
        data[1][2] = 2;

        int[] values = {1,2,4};
        System.out.println();
    }


    private static int[] data = new int[7];
    public static void main(String[] args) {
        for (int i = 3; i <10; i++) {
            System.out.println(getExcelData(i));
        }
    }
    private static int getExcelData(int column) {
        return data[column-3];
    }
}

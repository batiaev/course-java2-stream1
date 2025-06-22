package com.batiaev.java1.lesson2;

import com.batiaev.java1.lesson1.Homework;

/**
 * Lesson2
 *
 * @author anton
 * @since 25/01/18
 */
public class Lesson2 {
    public static void main(String[] args) {

//        switchExample();
//        forLoop();

        Homework.task6(4);


        String[] strings = new String[5];
        strings[0] = new String("");

        int[] array = new int[5];

        Object[] objects = new Object[5];


        int[][] table = new int[4][4];
        int[][] table2 = new int[4][];
        table2[0] = new int[3];
        table2[1] = new int[10];

        int[][][] table5 = new int[4][][];
        int[][] table3 = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {2, 3, 4, 5},
                {2, 3, 4, 5}
        };

        for (int row = 0; row < table3.length; row++) {
            for (int column = 0; column < table3.length; column++) {
                table3[row][column] = row * column * 2;
            }
        }

        int[] array2 = {5, 4, 3, 2, 5};

        for (int i = 0; i < array.length; i++) {
            if (i % 3 == 0) break;
            else if (i % 2 == 0) continue;

            array[i] = i + 3;
        }
        for (int value : array) {
            System.out.println(value);
        }
    }

    private static void forLoop() {
        int sum = 0;
        for (int i = 0; i < 10; ++i) {
            sum += i;
        }
        System.out.println("Summa=" + sum);
    }

    private static void switchExample() {

        int a = 123;
        switch (a) {
            case 1:
                System.out.println("a = 1");
                break;
            case 3:
                System.out.println("a = 3");
                break;
            case 5:
                System.out.println("a = 5");
                break;
            default:
                System.out.println("Ни одно из условий не сработало a="+a);
                break;
        }
    }
}

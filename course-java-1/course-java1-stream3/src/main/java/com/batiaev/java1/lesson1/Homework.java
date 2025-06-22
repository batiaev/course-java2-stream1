package com.batiaev.java1.lesson1;

import java.time.Year;

/**
 * Homework
 *
 * @author anton
 * @since 25/01/18
 */
public class Homework {
    public static void main(String[] args) {
        //FIXME
//        task2();
//        double result3 = task3(2, 4, 5, 7);
//        System.out.println("Result3 = " + result3);
//        boolean result4 = task4(6, 7);
//        task5(10);
//        task5(-190);
//        task6(-18);
//        task7("Anton");
//        task8(2018);


        for (int year = 2000; year < 2500; year++) {
            if (Year.isLeap(year) != task8(year))
                System.out.println("Wrong condition for year " + year);
        }
    }

    private static boolean task8(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    private static void task7(String name) {
        System.out.println("Привет " + name);
    }

    public static boolean task6(int a) {
        return a < 0;
    }

    private static boolean task5(int a) {
        return a >= 0;
    }

    private static boolean task4(int a, int b) {
        int sum = a + b;
        return 10 <= sum && sum <= 20;
    }

    private static double task3(double a, double b, double c, double d) {
        return a * (b + c / d);
    }

    private static void task2() {
        int a = 0;
        double val = 14.5;
        String name = "Anton";
    }
}

package com.batiaev.java1.lesson1;

/**
 * Homework
 *
 *
 * @author anton
 * @since 07/12/17
 */
public class Homework {
    public static void main(String[] args) {
        int a = 5;
        double calculate = calculate(1, 2, 3, 4);
        System.out.println(calculate);
    }

    private static double calculate(int a, int b, int c, int d) {

        return a * (b + (c / d));
    }

    private static boolean test3(int a, int b) {
        int sum = a + b;
        return sum > 10 && sum < 20;
    }

    private static boolean test4(int a) {
        return a <= 0;
    }

    private static void test4(String name) {
        System.out.println("Привет " + name + "!");
    }

    private static void test5(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 == 0)) {
            System.out.println("Високосный");
        } else {
            System.out.println("не високосный");
        }
    }
}

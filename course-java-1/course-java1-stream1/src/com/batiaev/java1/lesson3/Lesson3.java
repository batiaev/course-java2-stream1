package com.batiaev.java1.lesson3;


import java.util.Scanner;

/**
 * Lesson3
 *
 * @author anton
 * @since 11/12/17
 */
public class Lesson3 {
    public static void main(String[] args) {
//
        String equals = " = ";
        double value = 123456789.987654932;
        String test = "asd";
//

        System.out.format("%2s value %1s", test, equals);

//        int value = getValue();
//        System.out.println("Value: 10 < " + value + " < 30 ");


//        testMethod();
//        testMethod(5);
//        testMethod(1, 2);
//        testMethod(1, 2, 3, 4, 5, 6);

        long a2 = 789L;
        summa(5L,a2,7);
        summa(10.3, 6.7);
        summa(3, 9);
    }

    private static void summa(long a1, long a2, long a3) {
        System.out.println(a1 + a2 + a3);
    }

    private static void summa(double a1, double a2) {
        System.out.println(a1 + a2);
    }

    private static void summa(int a1, int a2) {
        System.out.println(a1 + a2);
    }

    private static void testMethod(int... value) {
        System.out.println(value);
    }

    private static int getValue() {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.println("Введите число в диапазоне [10,30]: ");
            value = scanner.nextInt();
        } while (value > 30 || value < 10);
        return value;
    }
}

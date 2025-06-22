package com.batiaev.java1.lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        int a = 14;
        double value = 3.1415;
        Double value2 = value;
        String name = "Anton";

        int summa = summa(a, 17);
        summa += 4;
        System.out.println(summa);

        boolean condition = summa > 30 && summa < 100 && summa != 55;
        int amount = 0;
        if (condition) {
            summa += 1;
            amount = 100;
            log("Summa > 30 & <100 and = " + summa);
        } else if (summa == 55) {
            System.out.println("summa = 55");
        } else {
            System.out.println("oops");
        }
        System.out.println(amount);

        System.out.println("Hello world!");
    }

    private static void log(String value) {
        System.out.print(value);
    }

    public static int summa(int first, int second) {
        log("Summa " + first + " and " + second + " = " + (first + second));
        return first + second;
    }
}

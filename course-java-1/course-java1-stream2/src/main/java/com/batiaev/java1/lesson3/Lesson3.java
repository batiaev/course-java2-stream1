package com.batiaev.java1.lesson3;

import java.util.Random;
import java.util.Scanner;

/**
 * Lesson3
 *
 * @author anton
 * @since 29/01/18
 */
public class Lesson3 {
    public static void main(String[] args) {
        //FIXME
        for (int i = 0; i < 10; i++)
            System.out.print("Anton");
        System.out.println("Hello!");
        Scanner sc = new Scanner(System.in);
        System.out.println(sc);
        System.out.println(new Lesson3());
//        int i = sc.nextInt();
//        String line = sc.nextLine();
//        String next = sc.next();
//        System.out.println(next);
//        System.out.println("I=" + i);
//        sc.hasNext();
        double value = 314159123156789.5;
        System.out.println(value);
        System.out.format("%s%n", value);
        System.out.format("%f%n", value);
        System.out.format("%.4f", value);
        String formattedValue = String.format(
                "Hello %s%nValue = %.3f and something more.. %n",
                "Anton", value);
        float Value = (float) (Math.random() *10);
    }
}

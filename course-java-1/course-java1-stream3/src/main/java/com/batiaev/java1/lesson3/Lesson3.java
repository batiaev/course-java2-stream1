package com.batiaev.java1.lesson3;

import java.util.Arrays;
import java.util.Random;

/**
 * Lesson3
 *
 * @author anton
 * @since 12/03/18
 */
public class Lesson3 {
    public static void main(String[] args) {

        Random random = new Random();
//        int i = random.nextInt(2);

        for (int i = 0; i < 100; ++i) {
//            int random1 = random.nextInt(10);
            int random1 = (int) (Math.random() + 0.5);
            System.out.print(" " + random1);
        }
        StringBuffer stringBuffer;
        StringBuilder stringBuilder;

//        double appetite = 1234.14159123546;
//        String format = String.format("appetite = %.3f%n", appetite);
//        System.out.println(format);
//        System.out.print("!");

//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        System.out.println("s="+s);
//        int first = 0;
//        while (scanner.hasNext()) {
//            first = Integer.valueOf(scanner.next());
//            System.out.println("Value = "+first);
//        }
    }
}

package com.batiaev.java1.lesson3;

import java.util.Random;
import java.util.Scanner;

/**
 * Homework
 *
 * @author anton
 * @since 15/03/18
 */
public class Homework {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        int playMore;//[0,1]
        do {
            int step = 0;
            int random = new Random().nextInt(10);
//            int random = (int) (Math.random() * 10);
            System.out.print("Введите число от 0 до 9: ");
            int scan = sc.nextInt();
            if (scan == random) {
                System.out.println("Угадали");
            } else {
                while (scan != random && step < 3) {
                    step++;
                    System.out.println(scan > random
                            ? "Число больше загаданного"
                            : "Число меньше");
                    scan = sc.nextInt();
                }
            }
            do {
                System.out.println("Повторить? 1 - да / 0 - нет");
                playMore = sc.nextInt();
            } while (playMore != 0 && playMore != 1);
        } while (playMore == 1);
    }

    private static void task2() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        int index = (int) (Math.random() * words.length);
        String scan;
        String word = words[index];
        do {
            System.out.println("Введите слово");
            scan = sc.nextLine();
            if (word.equals(scan)) {
                System.out.println("угадал");
            } else {
                int l = word.length();
                if (l > scan.length()) l = scan.length();

                int val = 15 - l;
                for (int i = 0; i < l; i++) {
                    if (word.charAt(i) == scan.charAt(i)) {
                        System.out.print(scan.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }

                for (int i = 1; i < val; i++)
                    System.out.print('#');
            }
        } while (!scan.equals(word));
    }
}

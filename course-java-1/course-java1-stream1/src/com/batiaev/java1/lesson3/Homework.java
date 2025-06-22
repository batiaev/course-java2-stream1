package com.batiaev.java1.lesson3;

import java.util.Scanner;

/**
 * Homework
 *
 * @author anton
 * @since 14/12/17
 */
public class Homework {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        game1();
        game2();
    }

    private static void game1() {

        int playMore;//[0,1]
        do {
            int step = 0;
            int random = (int) (Math.random() * 10);
            System.out.print("Введите число от 0 до 9: ");
            int scan = sc.nextInt();
            while (scan != random && step < 3) {
                step++;
                System.out.print(scan > random
                        ? "Число больше загаданного: "
                        : "Число меньше загаданного: ");
                scan = sc.nextInt();
            }
            do {
                System.out.print("Повторить игру? 1 - да / 0 - нет");
                playMore = sc.nextInt();
            } while (playMore != 1 && playMore != 0);
        } while (playMore == 1);
    }

    private static void game2() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int index = (int) (Math.random() * words.length);
        String scan;
        String word = words[index];
//        String word = "apple";
        for (int i = 0; i < 15; i++)
            System.out.print("#");

        do {
            System.out.print(" Введите слово: ");
            scan = sc.nextLine();
            if (word.equals(scan))
                System.out.println("Вы правы!");
            else {
                int l = word.length();
                if (l > scan.length()) l = scan.length();

                int val = 15;
                for (int i = 0; i < l; i++) {
                    if (word.charAt(i) == scan.charAt(i)) {
                        System.out.print(scan.charAt(i));
                        --val;
                    }
                }

                for (int i = 1; i < val; i++)
                    System.out.print('#');
            }
        } while (!scan.equals(word));
    }
}

package com.batiaev.java1.lesson4;

import java.util.Random;
import java.util.Scanner;

/**
 * Lesson4
 *
 * @author anton
 * @since 14/12/17
 */
public class Lesson4 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static char[][] map;
    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 3;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    public static void main(String[] args) {
        System.out.println("Start game");
        init();
        game();
    }

    private static void game() {
        while (true) {
            if (mapsIsFull()) {
                System.out.println("Ничья");
                break;
            }
            humanStep();
            if (validateMap(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            computerStep();
            if (validateMap(DOT_O)) {
                System.out.println("Победил компьютер");
                break;
            }
        }
        System.out.println("Игра завершена");
    }

    private static boolean mapsIsFull() {
        int totalSize = SIZE * SIZE;
        for (int row = 0; row < SIZE; ++row) {
            for (int column = 0; column < SIZE; ++column) {
                if (map[row][column] == DOT_X || map[row][column] == DOT_O)
                    --totalSize;
            }
        }
        return totalSize == 0;
    }

    private static boolean validateMap(char symb) {
        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
        return false;
    }

    private static void computerStep() {
        int row;
        int column;
        do {
            row = random.nextInt(SIZE);
            column = random.nextInt(SIZE);
        } while (!isCellValid(row, column));
        System.out.println("Компьютер походил в точку " + (row + 1) + " " + (column + 1));
        map[row][column] = DOT_O;
        printMap();
    }

    private static void humanStep() {
        int row;
        int column;
        do {
            System.out.format("Введите координаты в формате X Y (X - строка, Y - колонка)" +
                    "%n размер поля %s на %s%n", SIZE, SIZE);
            row = scanner.nextInt() - 1;
            column = scanner.nextInt() - 1;
        } while (!isCellValid(row, column));
        map[row][column] = DOT_X;
    }

    private static void printMap() {
        for (int row = 0; row < SIZE; ++row) {
            for (int column = 0; column < SIZE; ++column) {
                System.out.print(" " + map[row][column]);
            }
            System.out.println();
        }
    }

    private static boolean isCellValid(int row, int column) {
        return !(row < 0 || row > SIZE
                || column < 0 || column > SIZE
                || map[row][column] != DOT_EMPTY);
    }

    private static void init() {
        map = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; ++row) {
            for (int column = 0; column < SIZE; ++column) {
                map[row][column] = DOT_EMPTY;
                System.out.print(" " + map[row][column]);
            }
            System.out.println();
        }
    }
}

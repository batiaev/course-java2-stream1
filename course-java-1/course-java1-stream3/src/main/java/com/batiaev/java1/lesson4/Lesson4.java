package com.batiaev.java1.lesson4;

import java.util.Random;
import java.util.Scanner;

/**
 * Lesson4
 *
 * @author anton
 * @since 15/03/18
 */
public class Lesson4 {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static final int SIZE = 3;
    private static final int DOT_TO_WIN = SIZE;
    private static final char DOT_EMPTY = '.';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char[] players = new char[]{DOT_X, DOT_O};

    private static char[][] map;
    private static int emptyFields;

    public static void main(String[] args) {
        initMap();
        game();
    }

    private static void game() {
        System.out.println("Вы играете X");
        while (true) {
            for (char player : players) {
                if (isFilled()) {
                    System.out.println("Ничья!");
                    return;
                } else if (turn(player)) {
                    System.out.format("%s победил!%n", player);
                    return;
                }
            }
        }
    }

    private static boolean turn(char value) {
        switch (value) {
            case DOT_X:
                humanStep();
                break;
            case DOT_O:
                aiStep();
                break;
            default:
                System.out.println("Неизвестный игрок");
        }
        printMap();
        --emptyFields;
        return hasWinner(value);
    }

    private static void printMap() {
        for (char[] row : map) {
            for (char item : row) {
                System.out.print(" " + item);
            }
            System.out.println();
        }
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        emptyFields = SIZE * SIZE;
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map.length; column++) {
                map[row][column] = DOT_EMPTY;
                System.out.print(" " + DOT_EMPTY);
            }
            System.out.println();
        }
    }

    private static boolean isFilled() {
        return emptyFields <= 0;
    }

    private static void aiStep() {

        int row;
        int column;
        do {
            row = random.nextInt(SIZE);
            column = random.nextInt(SIZE);
        } while (!validate(row, column));
        System.out.format("Компьютер совершил ход в ячейку %s %s %n", row, column);
        map[row][column] = DOT_O;
    }

    private static void humanStep() {
        int row;
        int column;
        do {
            System.out.println("Введите значение строки и столбца," +
                    " в которые вы хотите сходить ([1,3])");
            row = scanner.nextInt() - 1;
            column = scanner.nextInt() - 1;
        } while (!validate(row, column));
        map[row][column] = DOT_X;
    }

    private static boolean validate(int row, int column) {
        return row >= 0 && row <= SIZE - 1
                && column >= 0 && column <= SIZE - 1
                && map[row][column] == DOT_EMPTY;
    }

    private static boolean hasWinner(char val) {
        //FIXME
        if (map[0][0] == val && map[0][1] == val && map[0][2] == val) return true;
        if (map[1][0] == val && map[1][1] == val && map[1][2] == val) return true;
        if (map[2][0] == val && map[2][1] == val && map[2][2] == val) return true;
        if (map[0][0] == val && map[1][0] == val && map[2][0] == val) return true;
        if (map[0][1] == val && map[1][1] == val && map[2][1] == val) return true;
        if (map[0][2] == val && map[1][2] == val && map[2][2] == val) return true;
        if (map[0][0] == val && map[1][1] == val && map[2][2] == val) return true;
        return map[2][0] == val && map[1][1] == val && map[0][2] == val;
    }
}

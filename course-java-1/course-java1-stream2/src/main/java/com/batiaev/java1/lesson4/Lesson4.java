package com.batiaev.java1.lesson4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Lesson4
 *
 * @author anton
 * @since 01/02/18
 */
public class Lesson4 {
    private static char[][] map;
    private static final int SIZE =5 ;
    private static final int DOTS_TO_WIN = 4;

    private static final Scanner sc = new Scanner(System.in);
    private static Random random = new Random();
    private static Map<Character, String> names = new HashMap<>();

    private static final char DOT_EMPTY = '.';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        game();
    }

    private static void game() {
        while (true) {
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
            for (char key : names.keySet()) {
                turn(key);
                if (validateMap(key)) {
                    System.out.println("Победа " + names.get(key) + "!");
                    System.out.println("Игра завершена");
                    return;
                }
            }
        }
    }

    private static void turn(char value) {
        switch (value) {
            case DOT_X:
                humanTurn();
            case DOT_O:
                aiTurn();
            default:
                System.out.println("unknown char");
        }
    }

    private static void aiTurn() {
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

    private static boolean validateMap(char value) {
        if (map[0][0] == value && map[0][1] == value && map[0][2] == value) return true;
        if (map[1][0] == value && map[1][1] == value && map[1][2] == value) return true;
        if (map[2][0] == value && map[2][1] == value && map[2][2] == value) return true;
        if (map[0][0] == value && map[1][0] == value && map[2][0] == value) return true;
        if (map[0][1] == value && map[1][1] == value && map[2][1] == value) return true;
        if (map[0][2] == value && map[1][2] == value && map[2][2] == value) return true;
        if (map[0][0] == value && map[1][1] == value && map[2][2] == value) return true;
        if (map[2][0] == value && map[1][1] == value && map[0][2] == value) return true;
        return false;
    }

    private static void initMap() {
        names.put(DOT_X, "пользователя");
        names.put(DOT_O, "компьютера");

        map = new char[SIZE][SIZE];
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map.length; column++) {
                map[row][column] = DOT_EMPTY;
                System.out.print(" " + map[row][column]);
            }
            System.out.println();
        }
    }

    private static void printMap() {
        for (char[] row : map) {
            for (char cell : row) {
                System.out.print(" " + cell);
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int row;
        int column;
        do {
            System.out.println("Ввести координаты в формате [номер строки] [номер столбца]");
            row = sc.nextInt() - 1;
            column = sc.nextInt() - 1;
        } while (!isCellValid(row, column));
        map[row][column] = DOT_X;
    }

    private static boolean isCellValid(int row, int column) {
        return row >= 0 && row < SIZE
                && column >= 0 && column < SIZE
                && map[row][column] == DOT_EMPTY;
    }

    public static boolean isFull() {
        int availableCells = SIZE * SIZE;
        for (char[] row : map) {
            for (char cell : row) {
                if (cell != DOT_EMPTY)
                    --availableCells;
            }
        }
        return availableCells == 0;
    }
}

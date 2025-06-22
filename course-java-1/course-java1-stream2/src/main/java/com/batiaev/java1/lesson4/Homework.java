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
public class Homework {
    private static char[][] map;
    private static final int SIZE = 5;
    private static final int DOTS_TO_WIN = SIZE - 1;
    private static int lastRow;
    private static int lastCol;

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
        if (onMap(lastRow, lastCol - 1)) {
            row = lastRow;
            column = lastCol + 1;
            if (isCellValid(row, column)) {
                map[row][column] = DOT_O;
                lastRow = row;
                lastCol = column;
            }
        }
        if (onMap(lastRow, lastCol + 1)) {
            row = lastRow;
            column = lastCol - 1;
            if (isCellValid(row, column)) {
                map[row][column] = DOT_O;
                lastRow = row;
                lastCol = column;
            }
        }
        if (onMap(lastRow - 1, lastCol)) {
            row = lastRow + 1;
            column = lastCol;
            if (isCellValid(row, column)) {
                map[row][column] = DOT_O;
                lastRow = row;
                lastCol = column;
            }
        }
        if (onMap(lastRow + 1, lastCol)) {
            row = lastRow - 1;
            column = lastCol;
            if (isCellValid(row, column)) {
                map[row][column] = DOT_O;
                lastRow = row;
                lastCol = column;
            }
        }
        if (onMap(lastRow - 1, lastCol - 1)) {
            row = lastRow + 1;
            column = lastCol + 1;
            if (isCellValid(row, column)) {
                map[row][column] = DOT_O;
                lastRow = row;
                lastCol = column;
            }
        }
        if (onMap(lastRow + 1, lastCol + 1)) {
            row = lastRow - 1;
            column = lastCol - 1;
            if (isCellValid(row, column)) {
                map[row][column] = DOT_O;
                lastRow = row;
                lastCol = column;
            }
        }

        row = column = SIZE / 2;
        if (isCellValid(row, column)) {
            map[row][column] = DOT_O;
        } else {
            do {
                row = random.nextInt(SIZE);
                column = random.nextInt(SIZE);
            } while (!isCellValid(row, column));
        }
        System.out.println("Компьютер походил в точку " + (row + 1) + " " + (column + 1));
        map[row][column] = DOT_O;
        printMap();
    }

    private static boolean validateMap(char value) {
        boolean row;
        boolean column;
        boolean diagonalLR;
        boolean diagonalRL;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                row = true;
                column = true;
                diagonalLR = true;
                diagonalRL = true;
                for (int k = 0; k < DOTS_TO_WIN; k++) {



                    row &= (map[i][j + k] == value);
                    row = row && (map[i][j + k] == value);




                    column &= (map[j + k][i] == value);
                    if (i <= SIZE - DOTS_TO_WIN) {
                        diagonalLR &= (map[i + k][j + k] == value);
                        diagonalRL &= (map[i + k][SIZE - j - k - 1] == value);
                    } else {
                        diagonalLR = false;
                        diagonalRL = false;
                    }
                }
                if (row || column || diagonalLR || diagonalRL) return true;
            }
        }
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
        lastCol = column;
        lastRow = row;
        map[row][column] = DOT_X;
    }

    private static boolean isCellValid(int row, int column) {
        return onMap(row, column)
                && map[row][column] == DOT_EMPTY;
    }

    private static boolean onMap(int row, int column) {
        return row >= 0 && row < SIZE
                && column >= 0 && column < SIZE;
    }

    private static boolean isFull() {
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

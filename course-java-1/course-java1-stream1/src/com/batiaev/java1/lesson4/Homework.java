package com.batiaev.java1.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Homework {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static char[][] map;
    private static int SIZE = 5;
    private static int DOTS_TO_WIN = 4;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static int lastRow, lastCol;

    public static void main(String[] args) {
        System.out.println("Start game");
        init();
        game();
    }

    private static void game() {
        int winner;
        while (true) {
            winner = humanStep();
            if (winner != 0) break;
            winner = botStep();
            if (winner != 0) break;
        }
        printMap();
        switch (winner) {
            case 1:
                System.out.println("Человек победил");
                break;
            case 2:
                System.out.println("Компьютер победил");
                break;
            case 3:
                System.out.println("Ничья");
                break;
        }
    }

    private static void init() {
        map = new char[SIZE][SIZE];
        DOTS_TO_WIN = (DOTS_TO_WIN > SIZE) ? SIZE : DOTS_TO_WIN;
        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                map[row][col] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) System.out.print("  " + map[i][j]);
            System.out.println();
        }
    }

    private static boolean inMap(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private static boolean isX(int row, int col) {
        return inMap(row, col) && map[row][col] == DOT_X;
    }

    private static boolean isCellValid(int row, int col) {
        return (inMap(row, col) && map[row][col] == DOT_EMPTY);
    }

    private static int checkWinner(char who) {
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        for (int col = 0; col < DOTS_TO_WIN; col++) {
            diagonal1 &= (map[col][col] == who);
            diagonal2 &= (map[DOTS_TO_WIN - col - 1][col] == who);
            boolean line = true;
            boolean column = true;
            for (int row = 0; row < DOTS_TO_WIN; row++) {
                column &= (map[col][row] == who);
                line &= (map[row][col] == who);
            }
            if (column || line) return who == DOT_O ? 2 : 1;
        }

        if (diagonal1 || diagonal2) return who == DOT_O ? 2 : 1;

        for (char[] row : map) {
            for (char col : row) {
                if (col == DOT_EMPTY) return 0;
            }
        }
        return 3;
    }

    private static int humanStep() {
        int row;
        int col;
        printMap();
        do {
            System.out.print("Ваш ход: ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isCellValid(row, col));
        map[row][col] = DOT_X;
        lastRow = row;
        lastCol = col;
        return checkWinner(DOT_X);
    }

    private static int botStep() {
        int row, col;

        if (isX(lastRow, lastCol - 1)) {
            row = lastRow;
            col = lastCol + 1;
            if (isCellValid(row, col)) {
                map[row][col] = DOT_O;
                lastRow = row;
                lastCol = col;
                return checkWinner(DOT_O);
            }
        }
        if (isX(lastRow, lastCol + 1)) {
            row = lastRow;
            col = lastCol - 1;
            if (isCellValid(row, col)) {
                map[row][col] = DOT_O;
                lastRow = row;
                lastCol = col;
                return checkWinner(DOT_O);
            }
        }
        if (isX(lastRow - 1, lastCol)) {
            row = lastRow + 1;
            col = lastCol;
            if (isCellValid(row, col)) {
                map[row][col] = DOT_O;
                lastRow = row;
                lastCol = col;
                return checkWinner(DOT_O);
            }
        }
        if (isX(lastRow + 1, lastCol)) {
            row = lastRow - 1;
            col = lastCol;
            if (isCellValid(row, col)) {
                map[row][col] = DOT_O;
                lastRow = row;
                lastCol = col;
                return checkWinner(DOT_O);
            }
        }
        if (isX(lastRow - 1, lastCol - 1)) {
            row = lastRow + 1;
            col = lastCol + 1;
            if (isCellValid(row, col)) {
                map[row][col] = DOT_O;
                lastRow = row;
                lastCol = col;
                return checkWinner(DOT_O);
            }
        }
        if (isX(lastRow + 1, lastCol + 1)) {
            row = lastRow - 1;
            col = lastCol - 1;
            if (isCellValid(row, col)) {
                map[row][col] = DOT_O;
                lastRow = row;
                lastCol = col;
                return checkWinner(DOT_O);
            }
        }

        row = col = SIZE / 2;
        if (isCellValid(row, col)) {
            map[row][col] = DOT_O;
            lastRow = row;
            lastCol = col;
            return checkWinner(DOT_O);
        }
        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        } while (!isCellValid(row, col));
        map[row][col] = DOT_O;
        lastRow = row;
        lastCol = col;

        System.out.println("ход бота: " + (lastRow + 1) + " " + (lastCol + 1));
        return checkWinner(DOT_O);
    }
}
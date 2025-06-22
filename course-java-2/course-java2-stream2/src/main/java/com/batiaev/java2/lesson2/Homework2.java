package com.batiaev.java2.lesson2;

public class Homework2 {

    private static final int SIZE = 4;
    private static String[][] data = new String[][]{
            {"56", "32", "1", "32"},
            {"12", "18", "19", "98ads"},
            {"14", "14", "8", "18"},
            {"15", "56", "15", "91"}};

    public static void main(String[] args) {

        int value = calculateArraySum(data);
    }

    private static int calculateArraySum(String[][] data) {
        int result = 0;
        try {
            if (data.length != SIZE)
                throw new MyArraySizeException("Invalid array size");
            for (int i = 0; i < data.length; i++) {
                if (data[i].length != SIZE)
                    throw new MyArraySizeException("Invalid array size");

                for (int j = 0; j < data[i].length; j++) {
                    try {
                        result += Integer.parseInt(data[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyDataArrayException("Invalid value = " + data[i][j], i, j, e);
                    }
                }
            }
        } catch (MyArrayException e) {
            e.printStackTrace();
//            System.out.println(e.toString());
        }
        return result;
    }
}

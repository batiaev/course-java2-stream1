package com.batiaev.java2.lesson2;

public class Main {
    public static void main(String[] args) {

        String[][] arrays = new String[][]{
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        try {
            int sum = calculateSum(arrays);
            System.out.println("Array sum = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Size problem: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Value problem: " + e.getMessage());
        }
    }


    private static int calculateSum(String[][] data)
            throws MyArraySizeException, MyArrayDataException {

        int sum = 0;
        if (data.length != 4) throw new MyArraySizeException("Invalid array size", data.length);

        for (int i = 0; i < data.length; i++) {
            String[] val = data[i];
            for (int j = 0; j < val.length; j++) {
                if (val.length != 4)
                    throw new MyArraySizeException("Invalid inner array size", data.length);

                try {
                    sum += Integer.parseInt(val[j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid element value", val[j], i, j);
                }
            }

        }
        return sum;
    }
}

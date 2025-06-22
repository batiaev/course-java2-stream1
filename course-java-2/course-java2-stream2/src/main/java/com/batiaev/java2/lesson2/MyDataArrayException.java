package com.batiaev.java2.lesson2;

public class MyDataArrayException extends MyArrayException {
    private int row;
    private int column;

    public MyDataArrayException(String s, int i, int i1, NumberFormatException e) {
        super(s, e);
    }

    public MyDataArrayException(String s, int i, int j) {
        super(s);
    }

//    @Override
//    public String toString() {
//        return "Invalid array data at " +
//                "row=" + row +
//                ", column=" + column;
//    }
}

package com.batiaev.java2.lesson2;

public class MyArrayException extends Exception {
    public MyArrayException(String s) {
        super(s);
    }

    public MyArrayException(String s, NumberFormatException e) {
        super(s, e);
    }
}

package com.batiaev.java2.lesson2;

/**
 * MyArraySizeException
 *
 * @author anton
 * @since 23/10/17
 */
public class MyArraySizeException extends MyException {
    private final int length;

    public MyArraySizeException(String s, int length) {
        super(s);
        this.length = length;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " array size = " + length;
    }
}

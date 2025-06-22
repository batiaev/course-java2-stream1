package com.batiaev.java2.lesson2;

/**
 * MyArrayDataException
 *
 * @author anton
 * @since 23/10/17
 */
public class MyArrayDataException extends MyException {
    private final int i;
    private final int j;
    private final String val;

    public MyArrayDataException(String message, String val, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
        this.val = val;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + String.format(" value[%s][%s]=%s", i, j, val);
    }
}

package com.batiaev.java2.lesson2;

/**
 * MyException
 *
 * @author anton
 * @since 19/10/17
 */
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyException) {
            return getMessage().equals(((MyException) obj).getMessage());
        }
        return false;
    }
}

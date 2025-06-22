package com.batiaev.java2.lesson2;

public class CustomException extends RuntimeException {
    public CustomException(String msg, Exception e) {
        super(msg, e);
    }
}

package com.batiaev.java3.lesson8;

public interface Test2 {
    default void exec() {
        System.out.println("test2");
    }
}

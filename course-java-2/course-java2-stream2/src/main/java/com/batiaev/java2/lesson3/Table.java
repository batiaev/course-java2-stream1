package com.batiaev.java2.lesson3;

public interface Table<T> {
    T get(int row, int column);
    T put(int row, int column, T value);
}

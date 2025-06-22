package com.batiaev.java3.lesson1.homework;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box<?>> {
    private List<T> data = new ArrayList<>();

    public Box() {}

    public void addFruit(T fruit) {
        data.add(fruit);
    }

    public double getWeight() {
        double weight = 0;
        for (T datum : data) {
            weight += datum.getWeight();
        }
        return weight;
    }

    @Override
    public int compareTo(Box<?> o) {
        return (int) (this.getWeight() - o.getWeight());
    }

    public boolean compare(Box o) {
        return Math.abs(getWeight() - o.getWeight()) < 0.000001;
    }

    public void addll(Box<T> o) {
        data.addAll(o.getData());
        o.clear();
    }

    private void clear() {
        data.clear();
    }

    private List<T> getData() {
        return data;
    }
}

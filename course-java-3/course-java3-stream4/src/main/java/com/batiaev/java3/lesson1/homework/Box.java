package com.batiaev.java3.lesson1.homework;

import java.util.List;

/**
 * Box
 *
 * @author anton
 * @since 22/08/19
 */
public class Box<T extends Fruit> implements Comparable<Box<?>> {
    private List<T> values;

    public T get(int idx) {
        return values.get(idx);
    }

    public void put(T v) {
        values.add(v);
    }

    public void putAll(Box<T> v) {
        this.values.addAll(v.values);
        v.clear();
    }

    private void clear() {
        values.clear();
    }

    private double getWeight() {
        double weight = 0;
        for (T value : values) {
            weight += value.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> o) {
        return this.getWeight() == o.getWeight();
    }

    @Override
    public int compareTo(Box<?> o) {
        if (this.getWeight() == o.getWeight())
            return 0;
        else
            return (int) (this.getWeight() - o.getWeight());
    }
}

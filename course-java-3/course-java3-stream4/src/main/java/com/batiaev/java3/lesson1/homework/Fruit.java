package com.batiaev.java3.lesson1.homework;

/**
 * Fruit
 *
 * @author anton
 * @since 22/08/19
 */
public abstract class Fruit {
    protected final double weight;
    protected final String type;

    protected Fruit(double weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }
}

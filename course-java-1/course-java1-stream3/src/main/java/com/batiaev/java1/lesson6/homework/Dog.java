package com.batiaev.java1.lesson6.homework;

/**
 * Dog
 *
 * @author anton
 * @since 26/03/18
 */
public class Dog extends Animal {

    public Dog(double dispersion) {
        super(10, 5, 400 + dispersion);

    }

    @Override
    protected boolean swim(double value) {
        return value >= 0 && value < maxSwim;
    }

    @Override
    protected boolean run(double value) {
        return value >= 0 && value < maxDistance;
    }

    @Override
    protected boolean jump(double value) {
        return value >= 0 && value < maxJump;
    }
}

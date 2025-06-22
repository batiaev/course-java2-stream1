package com.batiaev.java1.lesson6;

/**
 * Horse
 *
 * @author anton
 * @since 22/03/18
 */
public final class Horse extends Animal implements CanMove {

    private long distance;

    public Horse() {
        this("hourse", "black", 0);
    }

    public Horse(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public String getSound() {
        return "hrr";
    }

    @Override
    public void move() {
        System.out.println("Скакать " + distance);
    }

    @Override
    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    @Override
    public void run() {

    }
}

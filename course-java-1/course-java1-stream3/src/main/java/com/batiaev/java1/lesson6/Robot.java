package com.batiaev.java1.lesson6;

/**
 * Robot
 *
 * @author anton
 * @since 22/03/18
 */
public class Robot implements CanMove {
    private long distance;

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public void move() {
        System.out.println("moved on "+distance);
    }

    @Override
    public void run() {

    }
}

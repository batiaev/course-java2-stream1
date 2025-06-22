package com.batiaev.java1.lesson7;

/**
 * Plate
 *
 * @author anton
 * @since 25/12/17
 */
public class Plate {
    private int food = 15;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void addSomeFood(int food) {
        this.food = this.food + food;
    }

    public boolean decreaseFood(int food) {
        if (food <= this.food) {
            this.food -= food;
            return true;
        }
        return false;
    }
}

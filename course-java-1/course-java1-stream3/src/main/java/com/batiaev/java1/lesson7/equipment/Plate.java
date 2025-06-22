package com.batiaev.java1.lesson7.equipment;

/**
 * Plate
 *
 * @author anton
 * @since 26/03/18
 */
public class Plate {
    private double amountOfFood;

    public Plate(double amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public double getAmountOfFood() {
        return amountOfFood;
    }

    public void setAmountOfFood(double value) {
        this.amountOfFood = value > 0 ? value : 0;
    }

    public void addFood(double amountOfFood) {
        if (amountOfFood > 0)
            this.amountOfFood += amountOfFood;
    }

    public void descreaseFood(double value) {
        amountOfFood -= value;
    }
}

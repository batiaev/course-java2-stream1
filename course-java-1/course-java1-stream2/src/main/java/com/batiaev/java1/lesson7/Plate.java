package com.batiaev.java1.lesson7;

/**
 * Plate
 *
 * @author anton
 * @since 12/02/18
 */
public class Plate implements ContainsFood {
    private double amountOfFood;

    public Plate(double amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public double getAmountOfFood() {
        return amountOfFood;
    }

    public void setAmountOfFood(double amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    @Override
    public void addSomeFood(double amount) {
        amountOfFood += amount;
    }

    @Override
    public boolean decreaseFood(double amount) {
        if (amountOfFood < amount) {
            System.out.println("Еды недостаточно");
            return false;
        } else {
            amountOfFood -= amount;
            return true;
        }
    }
}

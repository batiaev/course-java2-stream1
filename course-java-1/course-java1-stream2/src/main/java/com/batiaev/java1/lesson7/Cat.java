package com.batiaev.java1.lesson7;

import static java.lang.Math.abs;

/**
 * Cat
 *
 * @author anton
 * @since 12/02/18
 */
public class Cat {
    private String name;
    private double amountOfFood;
    private boolean full;

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public Cat(String name, int amount) {
        this.name = name;
        amountOfFood = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmountOfFood() {
        return amountOfFood;
    }

    public void setAmountOfFood(double amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public boolean eat(ContainsFood plate) {
        boolean flag = plate.decreaseFood(amountOfFood);
        if (flag) {
            full = true;
        } else {
            full = false;
        }
        return full;
    }


    public static void main(String[] args) {
        System.out.println(min(14,-12));

    }

    private static int min(int a, int b) {
        return (a + b - abs(a - b)) / 2;
    }
}

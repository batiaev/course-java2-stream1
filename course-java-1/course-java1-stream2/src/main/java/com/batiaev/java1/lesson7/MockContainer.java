package com.batiaev.java1.lesson7;

/**
 * MockContainer
 *
 * @author anton
 * @since 12/02/18
 */
public class MockContainer implements ContainsFood {
    @Override
    public double getAmountOfFood() {
        return 20;
    }

    @Override
    public void setAmountOfFood(double amountOfFood) {

    }

    @Override
    public void addSomeFood(double amount) {

    }

    @Override
    public boolean decreaseFood(double amount) {
        return false;
    }
}

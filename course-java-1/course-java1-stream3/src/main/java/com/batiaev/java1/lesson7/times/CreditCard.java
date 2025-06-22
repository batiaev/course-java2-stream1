package com.batiaev.java1.lesson7.times;

/**
 * CreditCard
 *
 * @author anton
 * @since 26/03/18
 */
public class CreditCard {
    private long amount = 100;
    public void charge(int i) {
        amount -= amount;
    }
}

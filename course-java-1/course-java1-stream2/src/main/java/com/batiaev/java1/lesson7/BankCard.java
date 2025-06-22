package com.batiaev.java1.lesson7;

/**
 * BankCard
 *
 * @author anton
 * @since 12/02/18
 */
public class BankCard {
    private String name;
    private double amount;

    public BankCard(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }
}

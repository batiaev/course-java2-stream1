package com.batiaev.patterns.lesson6;

import lombok.Data;

@Data
public class Account {
    private String name;
    private double amount;
    private Money money;

    public Account(double amount) {
        this.amount = amount;
    }

    public void spend(double amount) {
        this.amount -= amount;
    }

    public void spendOnVacation(double amount) {
        this.amount -= amount;
    }
}

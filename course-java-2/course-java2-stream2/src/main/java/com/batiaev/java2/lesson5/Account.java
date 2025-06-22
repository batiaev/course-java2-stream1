package com.batiaev.java2.lesson5;

import java.util.concurrent.locks.Lock;

public class Account {
    private long id;
    private double amount;

    public Account(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public void transfer(Account account, double amount) {
        Account account1;
        Account account2;
        if (this.id < account.id) {
            account1 = this;
            account2 = account;
        } else {
            account1 = account;
            account2 = this;
        }

        synchronized (account1) {
            System.out.println(Thread.currentThread().getName() + " lock 1 resource");
            synchronized (account2) {
                System.out.println(Thread.currentThread().getName() + " lock 2 resource");
                if (account.amount > amount) {
                    account.amount -= amount;
                    this.amount += amount;
                }
            }
        }
    }

    public synchronized static void transfer(Account account1, Account account2, double amount) {
        account1.amount += amount;
        account2.amount -= amount;
    }

    public static void main(String[] args) {
        Account account1 = new Account(1, 150);
        Account account2 = new Account(2, 550);

        System.out.println("start 1 transfer");

        new Thread(() -> account1.transfer(account2, 100)).start();
        System.out.println("start 2 transfer");
        account2.transfer(account1, 100);
    }
}

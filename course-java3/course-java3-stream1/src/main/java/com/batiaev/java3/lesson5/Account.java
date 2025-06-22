package com.batiaev.java3.lesson5;

public class Account {
    private long id;
    private double amount;

    public Account(int i, double value) {
        id = i;
        amount = value;
    }

    public synchronized static void transfer(Account account1,
                                             Account account2,
                                             double amount) {
        account1.amount += amount;
        account2.amount -= amount;
    }

    public synchronized void transfer2(Account account, double amount) {
        synchronized (account) {
            this.amount += amount;
            account.amount -= amount;
        }
    }

    public void transfer(Account account, double amount) {
        synchronized (this) {
            synchronized (account) {
                this.amount += amount;
                account.amount -= amount;
            }
        }
    }

    public static void main(String[] args) {
        Account account1 = new Account(1, 500);
        Account account2 = new Account(2, 1000);
        Account account3 = new Account(3, 1000);
        Account account4 = new Account(4, 1000);

        new Thread(() -> transfer(account1, account2, 200)).start();
        new Thread(() -> transfer(account3, account4, 200)).start();
    }
}

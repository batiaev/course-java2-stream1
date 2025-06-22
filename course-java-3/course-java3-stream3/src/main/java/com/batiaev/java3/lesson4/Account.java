package com.batiaev.java3.lesson4;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
    private long id;
    private double amount;

    public Account(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public static void main(String[] args) {
        //FIXME
        Account account1 = new Account(1, 250);
        Account account2 = new Account(2, 100);
        Account account3 = new Account(2, 100);
        Account account4 = new Account(2, 100);

        new Thread(() -> account1.transfer(account2, 100)).start();
        new Thread(() -> account2.transfer(account1, 100)).start();
        System.out.println(account1.amount + " | " + account2.amount);

        account3.transfer(account4, 100);

//        transfer2(account1, account2, 50);
//        transfer2(account3, account4, 50);

    }

    public synchronized void transfer(Account account2, int amount) {
        sleep();
        synchronized (account2) {
            doTransfer(this, account2, amount);
        }
    }

    public void transfer(Account account1, Account account2, int amount) {
        Account first = account1.id > account2.id ? account1 : account2;
        Account second = account2.id > account1.id ? account1 : account2;
        synchronized (first) {
            synchronized (second) {
                doTransfer(account1, account2, amount);
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void transfer2(Account account1, Account account2, int amount) {
        doTransfer(account1, account2, amount);
    }

    private static void doTransfer(Account account1, Account account2, int amount) {
        account1.amount -= amount;
        account2.amount += amount;
    }
}

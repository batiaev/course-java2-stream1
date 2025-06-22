package com.batiaev.java2.lesson1;

public class Account {
    private static long count;
    private final long id;
    private String fio;
    protected double amount;

    public Account(int id) {
        this.id = id;
    }

    public Account() {
        this(0);
        System.out.println("Call default constructor");
    }

    public long getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addValue(double v) {
        this.amount += v;
    }

    public static void main(String[] args) {
        Account account1 = new Account();
        account1.setFio("Ivanov Ivan Ivanovich");
        account1.setAmount(1500);
        account1.setCount(15);

        System.out.println(account1.getFio());

        Account account2 = new Account(2);
        account2.setFio("test1");
        account2.setAmount(1000);
        account2.setCount(50);
    }

    private void setCount(int count) {
        this.count = count;
    }
}

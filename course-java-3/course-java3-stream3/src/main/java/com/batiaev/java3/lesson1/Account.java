package com.batiaev.java3.lesson1;

public class Account implements HasInfo {
    private String name;

    public Account(String name) {
        this.name = name;
    }

    @Override
    public String getInfo() {
        return "accountName=" + name;
    }
}

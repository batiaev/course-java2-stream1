package com.batiaev.patterns.lesson5.observer;

public class ConsoleObserver implements Observer {
    private final String name;

    public ConsoleObserver(String first) {
        this.name = first;
    }

    @Override
    public void process(String value) {
        System.out.println(name + " got " + value);
    }
}

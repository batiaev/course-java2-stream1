package com.batiaev.patterns.lesson5.templateMethod;

public abstract class Processor {

    public void process() {
        String params = loadParams();
        logState(params);
        calculate();
    }

    public abstract void calculate();

    public abstract String loadParams();

    private final void logState(String params) {
        System.out.println(params);
    }
}

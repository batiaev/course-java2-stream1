package com.batiaev.java3.lesson4.homework.mfu;

public class MFU {
    private Printer printer = new Printer();
    private Scanner scanner = new Scanner();

    public void print(int i) {
        printer.doJob(i);
    }

    public void scan(int i) {
        scanner.doJob(i);
    }
}

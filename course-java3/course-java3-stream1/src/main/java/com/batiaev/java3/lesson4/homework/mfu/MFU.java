package com.batiaev.java3.lesson4.homework.mfu;

public class MFU {
    private Printer printer = new Printer();
    private Scanner scanner = new Scanner();

    public static void main(String[] args) {
        MFU mfu = new MFU();
        mfu.printer.doJob(10);
        mfu.printer.doJob(20);
        mfu.scanner.doJob(35);
        mfu.scanner.doJob(3);
        mfu.printer.doJob(10);
    }
}

package com.batiaev.java3.lesson4;

/**
 * CalculationThread
 *
 * @author anton
 * @since 29/08/19
 */
public class CalculationThread  extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from calculation thread "+ Thread.currentThread().getName());
    }
}

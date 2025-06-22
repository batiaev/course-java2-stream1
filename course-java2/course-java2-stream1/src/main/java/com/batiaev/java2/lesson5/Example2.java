package com.batiaev.java2.lesson5;

/**
 * Example2
 *
 * @author anton
 * @since 30/10/17
 */
public class Example2 {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public static void main(String[] args) {
        Example2 e2 = new Example2();
        System.out.println("Start");
        new Thread(() -> e2.method1()).start();
        new Thread(() -> e2.method2()).start();
    }

    public void method1() {
        System.out.println("method1");
        synchronized (lock1) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method1 lock1");
            synchronized (lock2) {
                System.out.println("Synch block from method1");
            }
        }
    }

    public void method2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method2");
        synchronized (lock2) {
            System.out.println("method2 lock2");
            synchronized (lock1) {
                System.out.println("Synch block from method2");
            }
        }
    }
}

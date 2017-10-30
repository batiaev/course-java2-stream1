package com.batiaev.java2.lesson5;

/**
 * Example1
 *
 * @author anton
 * @since 30/10/17
 */
public class Example1 {
    public static void main(String[] args) {
        Example1 e1 = new Example1();
        Example1 e2 = new Example1();
        System.out.println("Start");
        new Thread(() -> e1.method1()).start();
        new Thread(() -> e2.method2()).start();
    }

    public synchronized static void method1() {
        System.out.println("method1");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("method1 finished");
    }

    public synchronized void method2() {
        System.out.println("method2");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("method2 finished");
    }
}

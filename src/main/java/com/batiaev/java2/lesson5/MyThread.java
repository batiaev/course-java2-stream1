package com.batiaev.java2.lesson5;

/**
 * MyThread
 *
 * @author anton
 * @since 30/10/17
 */
public class MyThread extends Thread {
    public static void main(String[] args) {
        new MyThread().start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.println("new thread: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

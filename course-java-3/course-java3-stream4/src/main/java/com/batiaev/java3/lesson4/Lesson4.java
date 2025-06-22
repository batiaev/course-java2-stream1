package com.batiaev.java3.lesson4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Lesson4
 *
 * @author anton
 * @since 29/08/19
 */
public class Lesson4 {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) throws InterruptedException {
//        printThreadInfo();
        final Thread thread = new Thread(Lesson4::deadlock2);
        thread.setName("my custom thread");
//        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        deadlock();
//        new CalculationThread().run();
//        new CalculationThread().start();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            final Future<Integer> submit = executorService.submit(() -> 5);
            executorService.execute(Lesson4::printThreadInfo);
        }

//        final Lesson4 lesson4 = new Lesson4();
//        final Lesson4 lesson42 = new Lesson4();
//        lesson4.printThreadInfo2();
//        lesson42.printThreadInfo2();
    }

    private synchronized static void printThreadInfo() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
    private void printThreadInfo4() {
        synchronized(Lesson4.class) {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }

    private synchronized void printThreadInfo2() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }

    private void printThreadInfo3() {
        synchronized(this) {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }

    private static void deadlock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "1");
        synchronized(lock1) {
            System.out.println(Thread.currentThread().getName() + "2");
            Thread.sleep(10000);
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "3");
            }
        }
    }
    private static void deadlock2() {
        System.out.println(Thread.currentThread().getName() + "11");
        synchronized(lock2) {
            System.out.println(Thread.currentThread().getName() + "22");
//            lock1.wait();
//            lock1.notify();
//            lock1.notifyAll();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "33");
            }
        }
    }
}

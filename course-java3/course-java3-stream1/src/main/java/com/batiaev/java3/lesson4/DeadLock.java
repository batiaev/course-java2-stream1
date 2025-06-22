package com.batiaev.java3.lesson4;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DeadLock {
    public static Object l1 = new Object();
    public static Object l2 = new Object();

    public static void main(String[] a) {
        System.out.println(Thread.currentThread().getName() + " thread started");
        new ThreadOne("thread1").start();
        new ThreadTwo("thread2").start();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock().lock();
    }

    private static class ThreadOne extends Thread {
        public ThreadOne(String thread1) {
            setName(thread1);
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " started ");
            synchronized (l1) {
                System.out.println(Thread.currentThread().getName()+  ": Holding lock 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (l2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }

    private static class ThreadTwo extends Thread {
        public ThreadTwo(String thread2) {
            setName(thread2);
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " started ");
            synchronized (l2) {
                System.out.println("Thread 2: Holding lock 2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (l1) {
                    System.out.println("Thread 2: Holding lock 2 & 1...");
                }
            }
        }
    }
}
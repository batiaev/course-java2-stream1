package com.batiaev.java3.lesson4;

import java.util.concurrent.atomic.AtomicInteger;

public class Lesson4 {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static long data = 1;

    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String[] args) {
        int i = atomicInteger.incrementAndGet();
//        example1();
//        example2();
        example3();
    }

    private static void example3() {
        Account account1 = new Account();
        Account account2 = new Account();

        new Thread(() -> transfer(account1, account2, 100)).start();
        new Thread(() -> transfer(account2, account1, 100)).start();
    }

    private static void transfer(Account account1, Account account2, double amount) {
        if (account1.getId() < account2.getId()) {
//            Lock lock = new ReentrantLock();
//            while (lock.tryLock()) {
//
//            }
            final Thread.State state = Thread.currentThread().getState();
            synchronized (account1) {
                synchronized (account2) {
                    account1.setAmount(account1.getAmount() - amount);
                    account2.setAmount(account2.getAmount() + amount);
                    System.out.println("Transaction complete!");
                }
            }
        } else {
            synchronized (account2) {
                synchronized (account1) {
                    account1.setAmount(account1.getAmount() - amount);
                    account2.setAmount(account2.getAmount() + amount);
                    System.out.println("Transaction complete!");
                }
            }
        }
    }


    private static void example2() {
        new Thread(Lesson4::process1).start();
        new Thread(Lesson4::process2).start();
    }

    private static void process1() {
        System.out.println("Start thread 1");
        synchronized (object1) {
            System.out.println("Lock object 1 at thread 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2) {
                System.out.println("Do some work at thread 1");
            }
        }
        System.out.println("stop thread 1");
    }

    private static void process2() {
        System.out.println("Start thread 2");
        synchronized (object2) {
            System.out.println("Lock object 2 at thread 2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1) {
                System.out.println("Do some work at thread 2");
            }
        }
        System.out.println("stop thread 2");
    }

    private static void example1() {
        Thread thread = new Thread(Lesson4::doSomeWork);
        thread.start();
//        doSomeWork();
        for (int i = 0; i < 10000; i++) {
            change(false);
//            System.out.println("Step " + i + " from "+ Thread.currentThread().getName());
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + data);
    }

    private static void doSomeWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("start thread " + Thread.currentThread().getName());
        for (int i = 0; i < 10000; i++) {
            change(true);
//            System.out.println("Step " + i + " from "+ Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName() + " " + data);
//        System.out.println("finish thread " + Thread.currentThread().getName());
    }

    private static synchronized void change(boolean increment) {
        if (increment) data++;
        else data--;
    }

    private synchronized void change2(boolean increment) {
        if (increment) data++;
        else data--;
    }
}

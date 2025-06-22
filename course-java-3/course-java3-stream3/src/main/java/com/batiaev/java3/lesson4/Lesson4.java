package com.batiaev.java3.lesson4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lesson4 {
    private volatile static long index = 0;
    private Object lock = new Object();
    private static Object lock2 = new Object();

    public void setLock2(Object lock) {
        this.lock2 = new Object();
    }

    public static void main(String[] args) {
        Runnable runnable = Lesson4::process;
        Thread thread = new Thread(runnable);
        thread.start();
        Lesson4 lesson4 = new Lesson4();
        Lesson4 secondValue = new Lesson4();
        lesson4.syncMethod3();
        new Thread(() -> lesson4.syncMethod3()).start();
        new Thread(() -> secondValue.syncMethod3()).start();


        new Thread(() -> lesson4.syncMethod4()).start();
        lesson4.setLock2(new Object());
        new Thread(() -> secondValue.syncMethod4()).start();

        treadInfoExample();
        executors();
    }

    private static void executors() {
        Account account1 = new Account(1, 450);
        Account account2 = new Account(2, 100);
        ExecutorService executorService = Executors.newFixedThreadPool(2);


        Future<?> submit = executorService.submit(() -> {
            Account.transfer2(account1, account2, 50);
        });

        if (submit.isDone() || submit.isCancelled()) {
//            submit.get();
        }
    }

    private static void treadInfoExample() {
        Thread thread = new Thread(() -> System.out.println("hello world!"));
        thread.setName("My Custom Thread");
        System.out.println("asda");
        thread.setPriority(9);
        thread.start();

        Thread.State state = thread.getState();
    }

    private static void process() {
        index++;
    }

    private synchronized static void syncMethod1() {

    }

    private synchronized void syncMethod2() {
        //do something....
    }

    private void syncMethod3() {
        synchronized (lock) {
            //do something...
        }
    }

    private void syncMethod4() {
        synchronized (lock2) {
            //do something...
        }
    }

    private class Build {
        private void doWork() {
            process();
        }
    }
}

class OuterBuild {
    private void doWork() {
//        Lesson4.process();
    }
}

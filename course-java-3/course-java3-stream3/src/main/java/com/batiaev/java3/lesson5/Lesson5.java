package com.batiaev.java3.lesson5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson5 {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier startLine = new CyclicBarrier(5);
        try {
            startLine.await();
        } catch (BrokenBarrierException ignored) {
        }
        startLine.isBroken();


        CountDownLatch countDownLatch = new CountDownLatch(4);
        countDownLatch.countDown();
        countDownLatch.await();

//        concurrentCollection();
//        atomic();
//        lock();
//        barrier();
//        semaphore();
//        cdl();
    }

    private static void cdl() {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void semaphore() throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);//парковка на 3 машины

        for (int i = 0; i < 4; ++i) {

            int finalI = i;
            new Thread(() -> {
                System.out.println("Машина " + finalI + " заняла парковку");
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Машина " + finalI + "ушли за продуктами");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();

                System.out.println("Машина " + finalI + " уехали");

            }).start();

        }

//        semaphore.acquire(2);//приехал автобус
//        semaphore.acquire();//приехал автомобиль
//        semaphore.release();//уехал автомобиль
//        semaphore.release(2);//уехал автобус
//        int availablePermits = semaphore.availablePermits();//количество свободных мест
    }

    private static void barrier() {
        CyclicBarrier barrier = new CyclicBarrier(3);
        barrier.reset();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void lock() {
        Lock lock = new ReentrantLock();
        lock.tryLock();
        lock.unlock();
    }

    private static void atomic() {
        AtomicInteger integer = new AtomicInteger(1);
        int andIncrement = integer.getAndIncrement();

        DoubleAdder adder = new DoubleAdder();
        adder.add(3.1415);
    }

    private static void concurrentCollection() {
        Map<String, Double> accounts = new HashMap<>();
//        accounts.put("12345", new Account());
//        accounts.put("123", new Account());
        Map<String, Double> synchronizedMap = Collections.synchronizedMap(accounts);
        Map<String, Double> synchronizedMap2 = new ConcurrentHashMap<>();
    }
}

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
    public static void main(String[] args) {
        concurrentCollection();
        atomic();
        lock();
        barrier();
        semaphore();
        cdl();
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

    private static void semaphore() {
        Semaphore semaphore = new Semaphore(3);
        //3
        //+1 = 2
        //+1 = 1
        //-1 = 3
        try {
            semaphore.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
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
            });
        }
    }

    private static void lock() {
        Lock lock = new ReentrantLock();
        lock.tryLock();
        lock.unlock();
    }

    private static void atomic() {
        AtomicInteger integer =new AtomicInteger(1);
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

package com.batiaev.java3.lesson4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class TestThreadClass implements Runnable {
    private String threadName = "thread1";
    private long count = 1L;
    private AtomicLong sequence = new AtomicLong(1);


    private Map<String, Quote> quotes = new HashMap<>();

    public void setQuote(String ticker, double value ) {
        Map<String, Quote> stringQuoteMap = Collections.synchronizedMap(quotes);
        Map<String, Quote> syncQuotes = new ConcurrentHashMap<>();
    }

    public void printQuotes() {
        quotes.forEach((s, quote) -> {
            System.out.format("Quote for %s is %s%n", s, quotes);
        });
    }

    private ThreadLocal<Long> countLocal = new ThreadLocal<Long>();

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void test() {
        if (lock.writeLock().tryLock()) {
            try {
                long l = sequence.incrementAndGet();
                Quote quote = new Quote();
                quote.setSequence(l);
            } finally {
                lock.writeLock().unlock();
            }
        } else {
            System.out.println("Skip this event");
        }

    }

    public void run() {
        System.out.println("Begin");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println("B " + threadName + ", счетчик: " + count);
            }
        } catch (InterruptedException е) {
            System.out.println("Ошибка при выполнении потока");
        }
        System.out.println("End");
    }

    public static void main(String[] args) {
        TestThreadClass mpObj = new TestThreadClass();
        Thread t1 = new Thread(mpObj);
        t1.start();
        t1.setDaemon(true);
    }
}

class Lesson4 {
    public static void main(String args[]) {
        System.out.println("Зaпycк основного потока");
        TestThreadClass mpObj = new TestThreadClass();
        Thread t1 = new Thread(mpObj);
        t1.setName("testThread");
        t1.start();
        for (int i = 0; i < 10; i++) {
            print();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ехс) {
                System.out.println("Пpepывaниe основного потока");
                System.out.println("Зaвepшeниe основного потока");
            }
        }
    }

    private synchronized static void print() {
        System.out.println("hello");
    }

    private synchronized void print2() {
        System.out.println("hello");
    }

    private Object monitor = new Object();

    private void print3() {
        synchronized (monitor) {
            System.out.println("hello");
        }
    }
}

package com.batiaev.java3.lesson4.homework;

import com.batiaev.java3.lesson4.homework.mfu.MFU;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private int pos = 0;
    private static int COUNT = 5;
    private final static List<String> list = Arrays.asList("A", "B", "C");

    public String getCurrent() {
        return list.get(pos);
    }

    public void move() {
        pos = (pos == list.size() - 1) ? 0 : pos + 1;
    }

    public static void main(String[] args) {
//        task2();
//        task1();
        task3();
    }

    private static void task3() {
        MFU mfu = new MFU();
        mfu.print(10);
        mfu.print(20);
        mfu.scan(35);
        mfu.scan(3);
        mfu.print(10);
    }

    private static void task1() {
        Controller controller = new Controller();
        list.forEach(symbol -> new NamedThread(symbol, COUNT, controller).start());
    }

    private static void task2() {
        List<Thread> threads = new ArrayList<>();
        try (FileWriter out = new FileWriter("out.txt")) {
            for (int j = 0; j < 3; j++) {
                int finalJ = j;
                Thread t = new Thread(() -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            String msg = "Thread " + finalJ + " write " + i + System.lineSeparator();
                            System.out.print(msg);
//                            out.write(msg);
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
                threads.add(t);
            }
            for (Thread t : threads) {
                t.join();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.batiaev.java3.lesson4.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        try (FileWriter out = new FileWriter("out.txt")) {
            for (int j = 0; j < 3; j++) {
                int finalJ = j;
                Thread t = new Thread(() -> {
                            for (int i = 0; i < 10; i++) {
                                try {
                                    System.out.println("Поток " + finalJ + " строка " + i);
//                            out.write();
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

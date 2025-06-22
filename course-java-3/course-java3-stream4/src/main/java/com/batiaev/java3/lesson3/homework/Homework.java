package com.batiaev.java3.lesson3.homework;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Scanner;

public class Homework {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Homework.class);
    private static File file = new File("src/main/resources/process.txt");

    public static void main(String[] args) {
        createFiles();
//        task1();
        task2();
//        process();
    }

    private static void task1() {
        File file = new File("src/main/resources/task1.txt");
        try (FileInputStream fromFile = new FileInputStream(file)) {
            byte[] arr = new byte[50];
            fromFile.read(arr);
            System.out.println(Arrays.toString(arr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void task2() {
        try (FileInputStream in1 = new FileInputStream("src/main/resources/task2_in1.txt");
             FileInputStream in2 = new FileInputStream("src/main/resources/task2_in2.txt");
             FileInputStream in3 = new FileInputStream("src/main/resources/task2_in3.txt");
             FileInputStream in4 = new FileInputStream("src/main/resources/task2_in4.txt");
             FileInputStream in5 = new FileInputStream("src/main/resources/task2_in5.txt");
             FileOutputStream all = new FileOutputStream("src/main/resources/task2_all.txt")) {

            Enumeration<InputStream> e = Collections.enumeration(
                    Arrays.asList(in1, in2, in3, in4, in5));
            SequenceInputStream seq = new SequenceInputStream(e);

            int c;
            System.out.println("Available = " + seq.available());
            while ((c = seq.read()) != -1) {
                all.write(c);
            }
            seq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void task3() {
        System.out.println("Введите номер страницы, чтобы узнать содержимое. Или /exit для выхода.");
        final int pageSize = 1800;
        final long pageCount = file.length() / pageSize;
        System.out.println("Количество страниц: " + pageCount);
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String s = scanner.next();
                if (s.equals("/exit")) return;

                try {
                    int num = Integer.parseInt(s) - 1;
                    if (num < 0 || num > pageCount - 1) {
                        log.warn("Такой страницы не существует");
                        continue;
                    }

                    RandomAccessFile accessToFile = new RandomAccessFile(file, "r");
                    accessToFile.seek(num * pageSize);
                    for (int i = 0; i < pageSize; i++) {
                        System.out.print((char) accessToFile.read());
                    }
                    System.out.println();
                    accessToFile.close();
                } catch (NumberFormatException e) {
                    log.warn("Вы ввели некорректные данные");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void createFiles() {
        try (FileWriter outTask1 = new FileWriter("src/main/resources/task1.txt");
             FileWriter outTask2_1 = new FileWriter("src/main/resources/task2_in1.txt");
             FileWriter outTask2_2 = new FileWriter("src/main/resources/task2_in2.txt");
             FileWriter outTask2_3 = new FileWriter("src/main/resources/task2_in3.txt");
             FileWriter outTask2_4 = new FileWriter("src/main/resources/task2_in4.txt");
             FileWriter outTask2_5 = new FileWriter("src/main/resources/task2_in5.txt")) {
            //
            for (int i = 0; i < 50; i++) {
                outTask1.write(i);
                outTask1.flush();
            }
            //
            for (int i = 0; i < 100; i++) {
                outTask2_1.write("A" + i);
                outTask2_2.write("B" + i);
                outTask2_3.write("C" + i);
                outTask2_4.write("D" + i);
                outTask2_5.write("E" + i);
            }
            outTask2_1.write(System.lineSeparator());
            outTask2_2.write(System.lineSeparator());
            outTask2_3.write(System.lineSeparator());
            outTask2_4.write(System.lineSeparator());
            outTask2_5.write(System.lineSeparator());
            outTask2_1.flush();
            outTask2_2.flush();
            outTask2_3.flush();
            outTask2_4.flush();
            outTask2_5.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter in = new BufferedWriter(new FileWriter(file))) {
            char c = 'a';
            for (int j = 0; j < 7_000; j++) {
                for (int i = 0; i < 1800; i++) {
                    in.write(c);
                }
                in.flush();
                if (c == 'z') {
                    c = 'a';
                } else c++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

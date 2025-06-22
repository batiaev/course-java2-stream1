package com.batiaev.java3.lesson2.homework;

import java.util.Scanner;

public class App {

    public static void echo(Object c) {
        System.out.println(c);
    }

    public static void main(String[] args) {
        Db db = new Db();
        Scanner in = new Scanner(System.in);

        while (true) {
            String str = in.nextLine();
            String[] data = str.split(" ");
            switch (data[0]) {
                case "/цена":
                    db.getProduct(data[1]);
                    break;
                case "/сменитьцену":
                    db.updatePrice(data[1], data[2]);
                    break;
                case "/товарыпоцене":
                    db.getProductsByCost(data[1], data[2]);
                    break;
                default:
                    System.out.println("Неправильная команда");
                    break;
            }
            db.close();
            break;
        }
    }
}

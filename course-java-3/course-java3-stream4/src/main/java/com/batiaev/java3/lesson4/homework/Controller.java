package com.batiaev.java3.lesson4.homework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * Controller
 *
 * @author anton
 * @since 02/09/19
 */
public class Controller {

    private int pos = 0;
    private static int COUNT = 5;
    private final static List<String> list = Arrays.asList("A", "B", "C");
    private final static ExecutorService executorService =
            Executors.newFixedThreadPool(list.size());

    public static List<String> getValues() {
        return list;
    }

    String getCurrent() {
        return list.get(pos);
    }

    void move() {
        pos = pos == list.size() - 1 ? 0 : pos + 1;
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        for (String symbol : list) {
            executorService.execute(
                    new TextPrinter(symbol, COUNT, controller,
                            System.out::print));
        }
    }

}

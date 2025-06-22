package com.batiaev.java1.lesson6;

import java.util.List;

/**
 * Manager
 *
 * @author anton
 * @since 08/02/18
 */
public class Manager {
    private List<Subscriber> listeners;

    public void calculate() {
        //do something
        for (Subscriber listener : listeners) {
            if (listener instanceof ConsoleLogger) {
                ConsoleLogger logger = (ConsoleLogger) listener;
            }
            listener.callBack();
        }
    }
}

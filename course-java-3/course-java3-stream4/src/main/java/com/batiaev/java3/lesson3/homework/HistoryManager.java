package com.batiaev.java3.lesson3.homework;

import java.util.Collection;
import java.util.List;

/**
 * HistoryManager
 *
 * @author anton
 * @since 29/08/19
 */
public interface HistoryManager {

    void storeMessage(String msg);

    default void storeMessage(String... messages) {
        for (String message : messages) {
            storeMessage(message);
        }
    }

    default void storeMessage(Collection<String> messages) {
        for (String message : messages) {
            storeMessage(message);
        }
    }

    List<String> loadHistory(int limit);

    default List<String> loadHistory() {
        return loadHistory(100);
    }
}

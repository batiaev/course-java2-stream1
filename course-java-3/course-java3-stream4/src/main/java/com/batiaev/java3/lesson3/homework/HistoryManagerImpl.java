package com.batiaev.java3.lesson3.homework;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * HistoryManagerImpl
 *
 * @author anton
 * @since 29/08/19
 */
public class HistoryManagerImpl implements HistoryManager {
    private final static String HISTORY_FILE = "history.log";

    public static void main(String[] args) {
        HistoryManager historyManager = new HistoryManagerImpl();
        for (int i = 0; i < 120; i++) {
            String message = UUID.randomUUID().toString();
            historyManager.storeMessage(message);
        }
        List<String> strings = historyManager.loadHistory(100);
        for (String line : strings) {
            System.out.println(line);
        }
    }

    @Override
    public void storeMessage(String msg) {
        List<String> history1 = loadHistory(100);
        history1.add(0, msg);
        if (history1.size() >= 100)
            history1.remove(history1.size() - 1);

        try (PrintWriter pw = new PrintWriter(new FileWriter(HISTORY_FILE))) {
            history1.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> loadHistory(int limit) {
        File history = getOrCreateHistoryFile();
        try (Stream<String> stream = Files.lines(history.toPath())) {
            return stream
                    .limit(limit)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private File getOrCreateHistoryFile() {
        File history = new File(HISTORY_FILE);
        if (!history.exists()) {
            try {
                history.createNewFile();
            } catch (IOException e) {
                System.out.println("Cannot create history file: "
                        + e.getLocalizedMessage());
            }
        }
        return history;
    }
}

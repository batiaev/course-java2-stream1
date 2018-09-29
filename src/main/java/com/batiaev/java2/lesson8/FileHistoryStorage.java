package com.batiaev.java2.lesson8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FileHistoryStorage implements HistoryStorage {

    RandomAccessFile fileHistory;
    private String HISTORY_FILE_PATH = "history.txt";
    private List<Long> messagesOffsets = new ArrayList<>();

    public FileHistoryStorage() {
        try {
            fileHistory = new RandomAccessFile(new File(HISTORY_FILE_PATH), "rw");
            fileHistory.seek(0);

            while (fileHistory.getFilePointer() < fileHistory.length()) {
                messagesOffsets.add(fileHistory.getFilePointer());
                fileHistory.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addMessage(String message) {
        try {
            fileHistory.seek(fileHistory.getFilePointer());
            messagesOffsets.add(fileHistory.getFilePointer());
            fileHistory.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getMessages(int count, int offset) {
        StringBuilder messages = new StringBuilder();
        if (count > 0 && offset >= 0 && offset < messagesOffsets.size()) {
            try {
                int startOffset = Math.max(0, messagesOffsets.size() - offset - count);
                fileHistory.seek(messagesOffsets.get(startOffset));
                for (int i = 0; i < Math.min(count, messagesOffsets.size() - startOffset); i++) {
                    messages.append(fileHistory.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return messages.toString();
    }
}

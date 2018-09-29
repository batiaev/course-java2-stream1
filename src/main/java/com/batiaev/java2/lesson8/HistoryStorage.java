package com.batiaev.java2.lesson8;

public interface HistoryStorage {

    void addMessage(String message);

    String getMessages(int count, int offset);

}

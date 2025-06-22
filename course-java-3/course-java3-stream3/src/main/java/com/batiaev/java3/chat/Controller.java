package com.batiaev.java3.chat;

public interface Controller {
    void sendMessage(String msg);

    void storeMessage(String msg);

    void closeConnection();

    void showUI(ClientUI clientUI);

    void sendMessage(Message authMessage);
}

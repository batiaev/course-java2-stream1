package com.batiaev.java2.lesson6;

import com.batiaev.java2.lesson8.Message;

public interface Controller {
    void sendMessage(String msg);

    void closeConnection();

    void showUI(ClientUI clientUI);

    void sendMessage(Message authMessage);
}

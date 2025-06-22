package com.batiaev.java3.chat;

public class MainClass {
    public static void main(String[] args) {
        Controller controller = new ClientController();
        ClientUI clientUI = new Client(controller);
        controller.showUI(clientUI);
    }
}

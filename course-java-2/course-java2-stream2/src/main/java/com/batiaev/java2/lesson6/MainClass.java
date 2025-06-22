package com.batiaev.java2.lesson6;

public class MainClass {
    public static void main(String[] args) {
        Controller controller = new ClientController();
        ClientUI clientUI = new Client(controller);
        controller.showUI(clientUI);
    }
}

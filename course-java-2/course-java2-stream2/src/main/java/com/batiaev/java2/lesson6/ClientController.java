package com.batiaev.java2.lesson6;

import com.batiaev.java2.lesson8.Message;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ClientController implements Controller {
    private final static String SERVER_ADDR = "localhost";
    private final static int SERVER_PORT = 8189;
    private ClientUI ui;

    private Socket sock;
    private Scanner in;
    private PrintWriter out;
    private int index = new Random().nextInt(3) + 1;

    public ClientController() {
        initConnection();
    }

    public void showUI(ClientUI ui) {
        this.ui = ui;
        ui.showUI();

//        Message message = new AuthMessage();
        sendMessage("/auth login" + index + " pass" + index);
    }

    @Override
    public void sendMessage(Message authMessage) {
        out.println(authMessage.toString());
    }

    private void initConnection() {
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                while (true) {
                    if (in.hasNext()) {
                        String w = in.nextLine();
                        if (w.startsWith("end session")) break;
                        ui.addMessage(w);
                    }
                }
            } catch (Exception e) {
            }
        }).start();
    }

    @Override
    public void sendMessage(String msg) {
        out.println(msg);
    }

    @Override
    public void closeConnection() {
        try {
            sendMessage("/exit");
            sock.close();
            out.close();
            in.close();
        } catch (IOException exc) {
        }
    }
}

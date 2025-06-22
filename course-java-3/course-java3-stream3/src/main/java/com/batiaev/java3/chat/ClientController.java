package com.batiaev.java3.chat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientController implements Controller {
    private final static String HISTORY_FILE = "history.log";
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
        ui.addMessage(loadHistory());
        ui.showUI();

//        Message message = new AuthMessage();
        sendMessage("/auth login" + index + " pass" + index);
    }

    private List<String> loadHistory() {
        File history = getOrCreateHistoryFile();
        try (Stream<String> stream = Files.lines(history.toPath())) {
            return stream.limit(100).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private File getOrCreateHistoryFile() {
        File history = new File(HISTORY_FILE);
        if (!history.exists()) {
            try {
                history.createNewFile();
            } catch (IOException e) {
                System.out.println("Cannot create history file: " + e.getLocalizedMessage());
            }
        }
        return history;
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
                        storeMessage(w);
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
    public void storeMessage(String msg) {
        List<String> history1 = loadHistory();
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

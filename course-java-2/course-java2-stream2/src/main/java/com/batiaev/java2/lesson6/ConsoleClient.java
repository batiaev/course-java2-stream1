package com.batiaev.java2.lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {
    private final static String SERVER_ADDR = "localhost";
    private final static int SERVER_PORT = 8189;
    private static Scanner consoleScanner = new Scanner(System.in);

    private Socket sock;
    private Scanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new ConsoleClient();
    }
    public ConsoleClient() {
        initConnection();
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
                        System.out.println(w);
                    }
                }
            } catch (Exception e) {
            }
        }).start();
        scanConsole();
    }

    private void scanConsole() {
        while (true) {
            String msg = consoleScanner.nextLine();
            if (msg != null && !msg.isEmpty()) {
                out.println(msg);
                if (msg.equals("end")) break;
            }
        }
    }
}

package com.batiaev.java2.lesson6.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * ClientHandler
 *
 * @author anton
 * @since 06/11/17
 */
public class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    private volatile static int CLIENTS_COUNT = 0;
    private String name;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new Scanner(socket.getInputStream());
            CLIENTS_COUNT++;
            name = "Client #" + CLIENTS_COUNT;
        } catch (IOException e) {
            System.out.println("Client handler initialization failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void run() {
        while (true) {
            if (in.hasNext()) {
                String w = in.nextLine();
                System.out.println(name + ": " + w);
                out.println("echo: " + w);
                if (w.equalsIgnoreCase("END")) break;
            }
        }
        try {
            System.out.println("Client disconnected");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }
}

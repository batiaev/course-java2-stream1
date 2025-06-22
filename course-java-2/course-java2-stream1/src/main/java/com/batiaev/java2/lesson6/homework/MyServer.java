package com.batiaev.java2.lesson6.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * MyServer
 *
 * @author anton
 * @since 06/11/17
 */
public class MyServer {

    private ClientHandler client;

    public static void main(String[] args) {
        new MyServer();
    }

    public MyServer() {
        Socket s = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Server created. Waiting for client...");
            s = server.accept();
            System.out.println("Client connected");
            client = new ClientHandler(s);
            new Thread(client).start();
            consoleChecker();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                System.out.println("Server closed");
                if (s != null) s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void consoleChecker() {
        Scanner s = new Scanner(System.in);

        while (true) {
            try {
                if (s.hasNext()) {
                    String message = s.nextLine();
                    String msg = "Server: " + message;
                    client.sendMessage(msg);
                    System.out.println(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

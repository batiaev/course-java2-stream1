package com.batiaev.java2.lesson7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * MyServer
 *
 * @author anton
 * @since 06/11/17
 */
public class MyServer {

    private List<ClientHandler> clients = new ArrayList<>();
    private AuthService authService;

    public static void main(String[] args) {
        new MyServer(new BaseAuthService());
    }

    public MyServer(AuthService authService) {
        this.authService = authService;

        Socket s = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Server created. Waiting for client...");
            while (true) {
                s = server.accept();
                ClientHandler client = new ClientHandler(this, s);
                new Thread(client).start();
                clients.add(client);
            }
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

    public AuthService getAuthService() {
        return authService;
    }

    public void sendBroadcastMessage(String msg) {
        for (ClientHandler c : clients) {
            if (c.isActive()) c.sendMessage(msg);
        }
    }

    public void close(Socket socket) {
        clients.removeIf(clientHandler -> clientHandler.getSocket().equals(socket));
        //FIXME
    }
}

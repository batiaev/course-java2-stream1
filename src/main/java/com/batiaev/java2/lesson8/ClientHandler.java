package com.batiaev.java2.lesson8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * ClientHandler
 *
 * @author anton
 * @since 06/11/17
 */
public class ClientHandler implements Runnable {
    private MyServer server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String name = null;
    private boolean isAuth = false;

    public ClientHandler(MyServer server, Socket socket) {
        this.server = server;
        try {
            this.socket = socket;
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Client handler initialization failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = in.readUTF();
                if (msg.startsWith(Command.AUTH_COMMAND.getText())) {
                    userAuth(msg);
                } else if (isAuth) {
                    if (msg.startsWith("/")) {
                        if (msg.startsWith(Command.PRIVATE_MESSAGE.getText() + " ")) {
                            sendPrivateMessage(msg);
                        } else if (msg.startsWith(Command.CHAT_MESSAGE.getText() + " ")) {
                            sendChatMessage(msg);
                        }
                    } else {
                        sendBroadcastMessage(name + " написал: " + msg);
                    }
                } else {
                    server.close(socket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Client disconnected");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isUserExist(String userName) {
        return server.getAuthService().contains(userName);
    }

    public void sendPersonalMessage(String user, String message) {
        server.sendPrivateMessage(name, user, message);
    }

    private void sendBroadcastMessage(String msg) {
        server.sendBroadcastMessage(msg);
    }

    public void sendMessage(String msg) {
        System.out.println(name + ": " + msg);
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isActive() {
        return isAuth;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getName() {
        return name;
    }

    private void sendChatMessage(String msg) {
        // /clients nick1     nick2   nick3 -m hello nick1
        String[] data = msg.substring(Command.CHAT_MESSAGE.getText().length() + 1).split(" -m ");
        if (data.length == 2) {
            String message = data[1];
            String[] nicknames = data[0].split(" ");
            List<String> validUsers = new ArrayList<>();
            for (String nickname : nicknames) {
                if (!nickname.trim().isEmpty()) {
                    if (isUserExist(nickname)) {
                        validUsers.add(nickname);
                    } else {
                        sendMessage("Invalid username " + nickname);
                        System.out.println("Invalid username " + nickname);
                    }
                }
            }

            validUsers.forEach(username -> sendPersonalMessage(username, message + " " + validUsers.toString()));

            sendMessage(message + " for users: " + validUsers.toString());
        } else {
            sendMessage("Invalid chat message command!");
            System.out.println("Invalid chat message command!");
        }
    }

    private void userAuth(String msg) {
        String[] data = msg.split(" ");

        if (data.length == 3) {
            name = server.getAuthService().getNick(data[1], data[2]);
            if (name != null) {
                sendMessage("/authok " + name);
                isAuth = true;
                sendBroadcastMessage(name + " зашел в чат!");
            } else {
                sendMessage("Неверные логин/пароль");
            }
        } else {
            server.close(socket);
        }
    }

    private void sendPrivateMessage(String msg) {
        String[] data = msg.substring(3).split(" ", 2);

        String userName = data[0];
        if (isUserExist(userName)) {
            sendMessage("я написал лично " + userName + ": " + data[1]);
            sendPersonalMessage(userName, data[1]);
        } else {
            sendMessage("Попытка написать несуществующему пользователю "
                    + userName);
        }
    }
}

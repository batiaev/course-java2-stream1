package com.batiaev.java2.lesson8;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * ClientHandler
 *
 * @author anton
 * @since 06/11/17
 */
public class ClientHandler extends Thread implements Closeable {
    private MyServer server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String name = "unknown";
    private String login = "";
    private boolean isAuth = false;
    private LocalDateTime connectTime = LocalDateTime.now();

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
            while (socket.isConnected() && !socket.isClosed()) {
                String msg = in.readUTF();
                if (msg.startsWith(Command.AUTH_COMMAND.getText())) {
                    userAuth(msg);
                } else if (isAuth) {
                    if (msg.startsWith("/")) {
                        if (msg.startsWith(Command.PRIVATE_MESSAGE.getText() + " ")) {
                            sendPrivateMessage(msg);
                        } else if (msg.startsWith(Command.CHAT_MESSAGE.getText() + " ")) {
                            sendChatMessage(msg);
                        } else if (msg.startsWith(Command.CHANGE_NICK.getText() + " ")) {
                            changeNick(msg);
                        }
                    } else {
                        sendBroadcastMessage(name + " написал: " + msg);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Client disconnected");
    }

    private void changeNick(String msg) {
        if(login.equals("")){
            return;
        }
        String newNick = msg.substring(Command.CHANGE_NICK.getText().length()).trim();

        String userName = newNick;
        if (isUserExist(userName)) {
            sendMessage("Ник не изменен! '" + newNick + "' - уже занят");
        } else {
            name = newNick;
            server.changeNick(login, newNick);
            sendMessage("Ник изменен на '" + newNick + "'!");
        }
    }

    private boolean isUserExist(String userName) {
        return server.getAuthService().contains(userName);
    }

    private void sendPersonalMessage(String user, String message) {
        server.sendPrivateMessage(name, user, message);
    }

    private void sendBroadcastMessage(String msg) {
        server.sendBroadcastMessage(msg);
    }

    void sendMessage(String msg) {
        System.out.println(name + ": " + msg);
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean isActive() {
        return isAuth;
    }

    Socket getSocket() {
        return socket;
    }

    String getHandlerName() {
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
                login = data[1];
                isAuth = true;
                sendBroadcastMessage(name + " зашел в чат!");
            } else {
                sendMessage("Неверные логин/пароль");
            }
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

    LocalDateTime getConnectTime() {
        return connectTime;
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}

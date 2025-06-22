package com.batiaev.java3.chat;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;

@Slf4j
public class ClientHandler implements Closeable {
    private Server server;
    private Socket socket;
    private String nick;
    private Channel channel;
    private LocalDateTime connectTime;

    public ClientHandler(Socket socket, Server server) {
        this.server = server;
        this.socket = socket;
        connectTime = LocalDateTime.now();

        try {
            channel = ChannelBase.of(socket);
            server.execute(this::process);
        } catch (IOException e) {
            log.error("Ошибка при подключении клиента", e);
        }
    }

    private void process() {
        auth();
        log.info(nick + " handler waiting for new massages");
        while (socket.isConnected()) {
            Message msg = channel.getMessage();
            if (msg == null) continue;
            switch (msg.getType()) {
                case EXIT_COMMAND:
                    server.unsubscribe(this);
                    log.info(nick + " - exit");
                    break;
                case PRIVATE_MESSAGE:
                    sendPrivateMessage(msg.getBody());
                    log.info(nick + " - send private message");
                    break;
                case BROADCAST_CHAT:
                    server.sendBroadcastMessage(nick + " : " + msg.getBody());
                    log.info(nick + " - send message");
                case CHANGE_LOGIN:
                    changeLogin();
                    log.info(nick + " - change login");
                default:
                    log.error(msg.getType().name() + " - invalid message type");
            }
        }
    }

    private void changeLogin() {

    }

    private void sendPrivateMessage(String messageWithNickTo) {
        int firstSpaceIndex = messageWithNickTo.indexOf(" ");
        final String nickTo = messageWithNickTo.substring(0, firstSpaceIndex);
        final String message = messageWithNickTo.substring(firstSpaceIndex).trim();
        if (server.isNickTaken(nickTo)) {
            server.sendPrivateMessage(nick, nickTo, nick + " -> " + nickTo + " : " + message);
        } else {
            sendMessage(nickTo + " not taken!");
        }
    }

    /**
     * Wait for command: "/auth login1 pass1"
     */
    private void auth() {
        while (true) {
            if (!channel.hasNextLine()) continue;
            Message message = channel.getMessage();
            if (MessageType.AUTH_MESSAGE.equals(message.getType())) {
                String[] commands = message.getBody().split(" ");// /auth login1 pass1
                if (commands.length >= 3) {
                    String login = commands[1];
                    String password = commands[2];
                    log.info("Try to login with " + login + " and " + password);
                    String nick = server.getAuthService()
                            .authByLoginAndPassword(login, password);
                    if (nick == null) {
                        String msg = "Invalid login or password";
                        log.error(msg);
                        channel.sendMessage(msg);
                    } else if (server.isNickTaken(nick)) {
                        String msg = "Nick " + nick + " already taken!";
                        log.error(msg);
                        channel.sendMessage(msg);
                    } else {
                        this.nick = nick;
                        String msg = "Auth ok!";
                        log.info(msg);
                        channel.sendMessage(msg);
                        server.subscribe(this);
                        break;
                    }
                }
            } else {
                channel.sendMessage("Invalid command!");
                log.error(message.getType().name() + " - invalid command before auth!");
            }
        }
    }

    public void sendMessage(String msg) {
        channel.sendMessage(msg);
    }

    public String getNick() {
        return nick;
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }

    public boolean isActive() {
        return nick != null;
    }

    public LocalDateTime getConnectTime() {
        return connectTime;
    }
}

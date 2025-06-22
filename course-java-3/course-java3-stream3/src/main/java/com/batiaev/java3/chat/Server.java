package com.batiaev.java3.chat;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Server implements Closeable {
    private static final long MAX_DELAY_TIME = 120;
    private ServerSocket serverSocket;
    private AuthService authService;
    private Map<String, ClientHandler> clients = new HashMap<>();
    private ExecutorService executor = Executors.newCachedThreadPool();

    public Server(AuthService authService) {
        this.authService = authService;
        try {
            serverSocket = new ServerSocket(8189);
            log.info("Сервер запущен, ожидаем подключения...");
            startKiller();
        } catch (IOException e) {
            log.error("Ошибка инициализации сервера", e);
            close();
        }
    }

    public static void main(String[] args) {
        AuthService baseAuthService = new BaseAuthService();
        Server server = new Server(baseAuthService);
        server.start();
    }

    @Override
    public void close() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            log.error("Ошибка закрытия сокета сервера", e);
        }
        System.exit(0);
    }

    private void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
            } catch (IOException e) {
                log.error("Ошибка подключения клиента", e);
            }
        }
    }

    public void sendBroadcastMessage(String msg) {
        for (ClientHandler client : clients.values()) {
            client.sendMessage(msg);
        }
    }

    public AuthService getAuthService() {
        return authService;
    }

    public boolean isNickTaken(String nick) {
        return clients.containsKey(nick);
    }

    public void subscribe(ClientHandler clientHandler) {
        String msg = "Клиент " + clientHandler.getNick() + " подключился";
        sendBroadcastMessage(msg);
        log.info(msg);
        clients.put(clientHandler.getNick(), clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        String msg = "Клиент " + clientHandler.getNick() + " отключился";
        sendBroadcastMessage(msg);
        log.info(msg);
        clients.remove(clientHandler.getNick());
    }

    public void sendPrivateMessage(String nickFrom, String nickTo, String message) {
        ClientHandler fromClient = clients.get(nickFrom);
        if (fromClient != null)
            fromClient.sendMessage(message);

        if (clients.containsKey(nickTo))
            clients.get(nickTo).sendMessage(message);
    }

    private void startKiller() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    LocalDateTime now = LocalDateTime.now();
                    Iterator<ClientHandler> i = clients.values().iterator();
                    while (i.hasNext()) {
                        ClientHandler client = i.next();
                        if (!client.isActive()
                                && Duration.between(client.getConnectTime(), now).getSeconds() > MAX_DELAY_TIME) {
                            log.error("Отключен не авторизованный пользователь");
                            client.close();
                            i.remove();
                        }
                    }
                } catch (Exception e) {
                    log.error("Ошибка при ожидании авторизации", e);
                }
            }
        }).start();
    }

    public void execute(Runnable task) {
        executor.submit(task);
    }
}
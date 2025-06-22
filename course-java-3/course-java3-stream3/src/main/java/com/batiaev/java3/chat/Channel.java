package com.batiaev.java3.chat;

public interface Channel {

    /**
     * Send by default broadcast message
     *
     * @param msg - message which should be send broadcast
     */
    default void sendMessage(String msg) {
        sendMessage(new Message(MessageType.BROADCAST_CHAT, msg));
    }

    void sendMessage(Message message);

    Message getMessage();

    boolean hasNextLine();
}

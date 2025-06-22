package com.batiaev.java2.lesson8;

public class AuthMessage extends Message {
    private String login;
    private String password;

    public AuthMessage(String login, String password) {
        super(MessageType.AUTH_MESSAGE, "");
        this.login = login;
        this.password = password;
    }

    public MessageType getType() {
        return MessageType.AUTH_MESSAGE;
    }

    @Override
    public String toString() {
        return "/auth " + login + " " + password;
    }
}

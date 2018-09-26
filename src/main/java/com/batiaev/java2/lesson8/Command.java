package com.batiaev.java2.lesson8;

/**
 * Command
 *
 * @author anton
 * @since 09/11/17
 */
public enum Command {
    AUTH_COMMAND("/auth"),
    AUTHOK_COMMAND("/authok"),
    DISCONNECTED("/disconnected"),
    PRIVATE_MESSAGE("/w"),
    CHAT_MESSAGE("/clients"),
    CHANGE_NICK("/nick");

    public String getText() {
        return text;
    }

    private String text;

    Command(String s) {
        text = s;
    }
}

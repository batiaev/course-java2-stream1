package com.batiaev.java2.lesson4.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.awt.event.KeyEvent.VK_ENTER;

public class Chat extends JFrame {
    private JTextArea chatMessagesArea;
    private JTextField messageField;

    public static void main(String[] args) {
        new Chat().setVisible(true);
    }

    private Chat() {
        init();
    }

    private void init() {
        setTitle("Chat");
        setBounds(300, 300, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        chatMessagesArea = new JTextArea("Welcome to chat!");
        chatMessagesArea.setPreferredSize(new Dimension(400, 400));
        add(chatMessagesArea);

        messageField = new JTextField();
        messageField.setToolTipText("Type your message here...");
        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == VK_ENTER) {
                    System.out.println("enter clicked");
                } else {
                    System.out.println(e.getKeyCode() + " " + e.getKeyChar());
                }
            }
        });

        messageField.addActionListener(e -> addMessage());

        JButton sendButton = new JButton("send");
        sendButton.addActionListener(e -> addMessage());

        JPanel bottomPanel = new JPanel();
        add(bottomPanel);

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.add(messageField);
        bottomPanel.add(sendButton);
    }

    private void addMessage() {
        if (messageField.getText().trim().isEmpty()) return;

        DateFormat df = new SimpleDateFormat("(HH:mm:ss)");
        chatMessagesArea.append("\n" + df.format(new Date()) + " : " + messageField.getText());
        messageField.setText("");
    }
}

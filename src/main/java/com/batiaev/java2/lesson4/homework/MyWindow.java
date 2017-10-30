package com.batiaev.java2.lesson4.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MyWindow
 *
 * @author anton
 * @since 30/10/17
 */
public class MyWindow extends JFrame {

    private JTextArea chatHistory;
    private JTextField messageBox;

    public static void main(String[] args) {
        new MyWindow().open();
    }

    private void open() {
        init();
        setVisible(true);
    }

    public void init() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 300, 400, 500);

        setLayout(new BorderLayout());

        chatHistory = new JTextArea();
        chatHistory.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatHistory);
        add(scrollPane, BorderLayout.CENTER);

        JPanel jPanel = new JPanel(new BorderLayout());
        add(jPanel, BorderLayout.SOUTH);

        messageBox = new JTextField();
        messageBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        jPanel.add(messageBox, BorderLayout.CENTER);

        JButton jb = new JButton("Отправить");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        jPanel.add(jb, BorderLayout.EAST);
    }

    private void sendMessage() {
        if (!messageBox.getText().trim().isEmpty()) {
            chatHistory.append("User: " + messageBox.getText() + System.lineSeparator());
            messageBox.setText("");
        }
        messageBox.grabFocus();
    }
}

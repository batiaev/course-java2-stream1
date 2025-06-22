package com.batiaev.java1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainWindow
 *
 * @author anton
 * @since 15/02/18
 */
public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        init();
//        init2();
        setVisible(true);
    }

    private void init() {

        JLabel label = new JLabel("asd");
        JTextField textField = new JTextField("");
        JTextArea jTextArea = new JTextArea();
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Apple");
        comboBox.addItem("Banana");
        comboBox.addItem("Mango");

        JButton[] buttons = new JButton[9];
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton(".");
            int finalI = i;
            buttons[i].addActionListener(e -> {
                buttons[finalI].setText("X");
                System.out.println("Click " + finalI);
            });
            add(buttons[i]);
        }

//        for (int i = 0; i < buttons.length; i++) {
//            buttons[i] = new JButton("Button #" + i);
//            buttons[i].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    printInfo();
//                }
//            });
//            buttons[i].addActionListener(event -> System.out.println("Click!"));
//            buttons[i].addActionListener(e -> printInfo());
//            buttons[i].addActionListener(this::actionPerformed);
//        }
    }

    private void printInfo() {
        System.out.println("Click!");
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }

    private void actionPerformed(ActionEvent e) {
        printInfo();
    }
}

package com.batiaev.java2.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyWindow extends JFrame {
    private Calculator calculator = new Calculator();

    public MyWindow() {
        init();
        addMenu();
        setVisible(true);
    }

    public static void main(String[] args) {
        MyWindow myWindow = new MyWindow();
    }

    private void init() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);


        JButton button = new JButton("Button 1 (PAGE_START)");
        add(button, BorderLayout.PAGE_START);

        JButton centerButton = new JButton("Button 2 (CENTER)");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object source = e.getSource();
                if (source instanceof JTextField) {

                    JTextField textField = (JTextField) source;
                    String text = textField.getText();
                    textField.setText(text + "1234");
                    textField.setEnabled(false);
                    System.out.println("Element activated with text: " + text);
                } else {
                    System.out.println("Button activated!");
                }
            }
        };
        centerButton.addActionListener(listener);
        centerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("another listener!");
                calculator.doSomething();
            }
        });

        centerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouse clicked");
            }
        });
        centerButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        JTextField textField = new JPasswordField();
        textField.addActionListener(listener);
        JTextField customField = new MyTextField();

        JButton button1;
        JCheckBox checkBox;
        JComboBox comboBox;
        JLabel label;
        JSlider slider;
        JTextArea textArea;


        centerButton.setPreferredSize(new Dimension(300, 300));
        add(centerButton, BorderLayout.CENTER);


        add(textField, BorderLayout.PAGE_END);


        button = new JButton("Button 3 (LINE_START)");
        add(button, BorderLayout.LINE_START);
        button = new JButton("5 (LINE_END)");
        add(button, BorderLayout.LINE_END);
    }

    private void addMenu() {
        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        JMenuItem miFileNew = new JMenuItem("New");
        JMenuItem miFileExit = new JMenuItem("Exit");
        mainMenu.add(mFile);
        mainMenu.add(mEdit);
        mFile.add(miFileNew);
        mFile.addSeparator(); // разделительная линия в меню
        mFile.add(miFileExit);
        miFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setJMenuBar(mainMenu);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("BYE");
            }
        });
    }

    private class Calculator {
        public void doSomething() {
            //FIXME
        }
    }
}

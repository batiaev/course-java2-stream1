package com.batiaev.java1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * MyWindow
 *
 * @author anton
 * @since 29/03/18
 */
public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 600, 200);
        init();
    }

    private void init() {
        MenuBar menuBar = new MenuBar();
        menuBar.add(new Menu("File"));
        setMenuBar(menuBar);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jFile = new JMenu("JFile");
        jFile.add(new JMenuItem("Exit"));
        jMenuBar.add(jFile);
        setJMenuBar(jMenuBar);

        JButton[] jbs = new JButton[5];
        JTextField textField = new JTextField("value");
        textField.addActionListener(MyWindow::staticProcessClick);
        for (int i = 0; i < 5; i++) {
            jbs[i] = new JButton("#" + i);
        }
        setLayout(new BorderLayout());
        add(jbs[0], BorderLayout.EAST);
        add(jbs[1], BorderLayout.WEST);
        add(jbs[2], BorderLayout.SOUTH);
        add(textField, BorderLayout.NORTH);
        add(jbs[4], BorderLayout.CENTER);
        JButton button = jbs[4];

        button.setToolTipText("smart button");
        jbs[1].setToolTipText("another example");

        MyWindow window = this;
        jbs[1].addActionListener(this::processClick);
        button.addActionListener(this::processClick);
        button.addActionListener(window::processClick);
        button.addActionListener(MyWindow::staticProcessClick);
        button.addActionListener(e -> processClick(button));
        button.addActionListener((ActionEvent e) -> processClick(button));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processClick(button);
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("test");
            }
        });
    }

    private static void staticProcessClick(ActionEvent e) {
        System.out.println("hello");
//        processClick((JButton) e.getSource());
    }

    private void processClick(ActionEvent e) {
        processClick((JButton) e.getSource());
    }

    private static void processClick(JButton button) {
        System.out.println("click " + button.getToolTipText());
    }

    public static void main(String[] args) {
        new MyWindow().setVisible(true);
        System.out.println("test");
    }
}

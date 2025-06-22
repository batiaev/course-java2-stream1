package com.batiaev.java1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * MyWindow
 *
 * @author anton
 * @since 28/12/17
 */
public class MyWindow extends JFrame {
    private static int SIZE = 3;
    private JButton[][] buttons = new JButton[SIZE][SIZE];

    public MyWindow() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        initMenu();
        initWindow();
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        setJMenuBar(menuBar);
    }

    private void initWindow() {
        setLayout(new GridLayout(SIZE, SIZE));

        for (int row = 0; row < SIZE; ++row) {
            for (int column = 0; column < SIZE; ++column) {
                buttons[row][column] = new JButton("");
                buttons[row][column].addActionListener(this::process);
//                buttons[row][column].addActionListener(e -> process(e));
//                buttons[row][column].addActionListener(new MyActionListener());
//                buttons[row][column].addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        process(e);
//                    }
//                });
                add(buttons[row][column]);
            }
        }
//        JTextField jTextField = new JTextField();
//        jTextField.setText("example");
//        jTextField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                jTextField.setVisible(false);
////                jTextField.getText().trim().isEmpty();
//                System.out.println("textfield performed");
//            }
//        });
//        jTextField.setToolTipText("This is text field");
//        add(jTextField);
        JTextArea area;
    }

    private void process(ActionEvent e) {
        Dialog dialog = new Dialog(this, true);
        dialog.setVisible(true);
        if (e.getSource() instanceof JButton)
            ((JButton) e.getSource()).setText("X");
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            process(e);
        }
    }

    public static void main(String... args) {
        new MyWindow().setVisible(true);
    }
}

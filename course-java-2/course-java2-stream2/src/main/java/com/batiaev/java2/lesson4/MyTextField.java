package com.batiaev.java2.lesson4;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyTextField extends JTextField {
    public MyTextField() {
        addActionListener(e -> {
            System.out.println("clicked");
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    @Override
    public void setText(String t) {
        super.setText(t + " Copyright 2018 Anton Batiaev");
    }

}

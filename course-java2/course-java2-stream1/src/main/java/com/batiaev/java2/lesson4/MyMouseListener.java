package com.batiaev.java2.lesson4;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * MyMouseListener
 *
 * @author anton
 * @since 26/10/17
 */
public class MyMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }
}

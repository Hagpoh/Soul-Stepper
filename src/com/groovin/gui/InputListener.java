package com.groovin.gui;



import com.groovin.gameSetup.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputListener implements KeyListener {

    public JTextField jTextField;


    public InputListener() {
        jTextField = new JTextField();
        jTextField.setSize(100, 100);
        jTextField.setColumns(15);
        jTextField.addKeyListener(this);
        jTextField.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // defining a string which is fetched by the getText() method of TextArea class
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Game game = Game.getInstance();
            try {
                game.play(jTextField.getText().toLowerCase());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            jTextField.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


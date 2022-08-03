package com.groovin.gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputListener implements KeyListener {

    JTextField jTextField;


    public InputListener() {
        jTextField = new JTextField();
        jTextField.setBounds(20, 50, 100, 100);
        jTextField.addKeyListener(this);


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // defining a string which is fetched by the getText() method of TextArea class
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = jTextField.getText();
            InputStream inputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
            System.setIn(inputStream);
            // System.out.println(text);
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            System.out.println(input);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}


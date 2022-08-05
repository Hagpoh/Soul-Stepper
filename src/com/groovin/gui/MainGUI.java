package com.groovin.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MainGUI {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Soul Stepper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1000, 1000));
        frame.setLayout(new GridLayout());
        frame.setLocationRelativeTo(null);
        JTextArea textArea = setTextOutput(frame);
        InputListener inputListener = new InputListener();
        JTextField inputArea = inputListener.jTextField;
        JLabel label = new JLabel("What would you like to do?");
        label.setLabelFor(inputArea);

        frame.add(textArea);
        inputArea.add(label);
        frame.add(inputArea);

        frame.pack();
        frame.setVisible(true);
    }

    public static JTextArea setTextOutput(JFrame frame) {
        JTextArea textArea = new JTextArea(50, 60);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        return textArea;
    }
}
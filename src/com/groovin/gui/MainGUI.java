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
        JTextField inputArea = new InputListener().jTextField;
        frame.add(inputArea);


        frame.setVisible(true);
    }

    public static JTextArea setTextOutput(JFrame frame) {
        JTextArea textArea = new JTextArea(50, 10);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        frame.add(textArea);
        frame.setVisible(true);
        return textArea;
    }
}
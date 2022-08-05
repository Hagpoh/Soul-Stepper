package com.groovin.gui;

import javax.swing.*;
import java.io.PrintStream;

class GameGUI extends JFrame {

    private JPanel mainPanel;
    private JTextArea outputArea;
    private JTextField inputArea;
    private JLabel inputLabel;
    private JLabel titlePicture;

    public GameGUI() {

        outputArea.setColumns(50);
        outputArea.setRows(50);

        PrintStream printStream = new PrintStream(new CustomOutputStream(outputArea));
        System.setOut(printStream);
        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        GameGUI gui = new GameGUI();
    }
}
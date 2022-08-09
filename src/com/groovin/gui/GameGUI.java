package com.groovin.gui;

import javax.swing.*;
import java.io.PrintStream;

class GameGUI extends JFrame {

    private JPanel mainPanel;
    private JTextArea outputArea;
    private JTextField inputArea;
    private JLabel inputLabel;
    private JLabel titlePicture;
    private JTextArea statusOutput;
    private JLabel statusTitle;
    private JLabel gameTextTitle;
    private JButton submitButton;
    private JLabel map;

    public GameGUI() {
        //Setting main content
        setContentPane(mainPanel);
        setTitle("Soul Stepper");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Setting title icon with a picture icon
        ImageIcon titleIcon = new ImageIcon(GUIHelper.getImage("/title.png"));
        titlePicture.setIcon(titleIcon);

        //Setting map icon with a picture icon
        ImageIcon mapIcon = new ImageIcon(GUIHelper.getImage("/map.jpg"));
        map.setIcon(mapIcon);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setOutput(String output) {
        outputArea.append("\n" + output);
    }

    public static void main(String[] args) {
        GameGUI gui = new GameGUI();
    }
}
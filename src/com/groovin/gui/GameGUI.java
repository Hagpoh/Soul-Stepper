package com.groovin.gui;

import com.groovin.character.Player;
import com.groovin.gameSetup.Game;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class GameGUI extends JFrame {

    private JPanel mainPanel;
    public JTextArea outputArea;
    private JTextField inputArea;
    private JLabel inputLabel;
    private JLabel titlePicture;
    private JTextArea statusOutput;
    private JLabel statusTitle;
    private JLabel gameTextTitle;
    private JButton submitButton;
    private JLabel map;

    private String input = "";

    private static GameGUI guiInstance = null;

    private GameGUI() {
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

        PrintStream printStream = new PrintStream(new CustomOutputStream(outputArea));
        System.setOut(printStream);

        //Set up our event listener for our button
        submitButton.addActionListener(e -> {
            input = inputArea.getText();
            inputArea.setText("");
            setOutput(input);
            synchronized (Game.class) {
                Game.class.notifyAll();
            }
            synchronized (Player.class) {
                Player.class.notifyAll();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static GameGUI getInstance() {
        if (guiInstance == null) {
            guiInstance = new GameGUI();
        }
        return guiInstance;
    }

    public void setOutput(String output) {
        outputArea.append("\n" + output);
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    public String getInput() {
        return input;
    }
}
package com.groovin.gui;

import com.groovin.character.Player;
import com.groovin.gameSetup.Game;
import com.groovin.gameSetup.SimpleAudioPlayer;
import javax.swing.event.*;

import javax.swing.*;
import java.io.PrintStream;

public class GameGUI extends JFrame {

    private JPanel mainPanel;
    public JTextArea outputArea;
    private JTextField inputArea;
    private JLabel inputLabel;
    private JLabel titlePicture;
    private JLabel gameTextTitle;
    private JButton submitButton;
    private JLabel map;
    private JButton playButton;
    private JButton pauseButton;
    private JSlider superSlide;
    private JButton restartButton;
    private JButton resumeButton;

    private String input = "";

    private static GameGUI guiInstance = null;
    private SimpleAudioPlayer audioPlayer;

    Game game = Game.getInstance();

    private GameGUI()  {

        audioPlayer = new SimpleAudioPlayer("/musicfiles/The Truth - Anno Domini Beats.wav");
        //Setting main content
        setContentPane(mainPanel);
        setTitle("Soul Stepper");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Setting title icon with a picture icon
        ImageIcon titleIcon = new ImageIcon(GUIHelper.getImage("/title.png"));
        titlePicture.setIcon(titleIcon);

        //Setting map icon with a picture icon
        ImageIcon mapIcon = new ImageIcon(GUIHelper.getImage("/map.png"));
        map.setIcon(mapIcon);

        PrintStream printStream = new PrintStream(new CustomOutputStream(outputArea));
        System.setOut(printStream);

        //Set up our event listener for our button
        playButton.addActionListener(e ->{
            audioPlayer.play();
        });
        pauseButton.addActionListener(e ->{
            audioPlayer.pause();
        });

        submitButton.addActionListener(e -> {
            input = inputArea.getText();
            inputArea.setText("");
            setOutput(input);
            outputArea.setText("");
            game.choice = input;
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

        superSlide.setInverted(false);
        superSlide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                audioPlayer.currentVolume = superSlide.getValue();
                audioPlayer.fc.setValue(audioPlayer.currentVolume);
            }
        });
    }

    public static GameGUI getInstance()  {
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
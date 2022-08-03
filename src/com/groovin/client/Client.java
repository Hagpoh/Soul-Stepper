package com.groovin.client;

import com.groovin.gameSetup.Game;
import com.groovin.gui.MainGUI;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        MainGUI.createAndShowGUI();
        //initiating game class
        Game game = new Game();
        //calling play method from game class.
        game.play();
    }
}
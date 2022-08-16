package com.groovin.client;

import com.groovin.gameSetup.Game;
import com.groovin.gui.GameGUI;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        //initiating game class
        GameGUI gui = GameGUI.getInstance();
        Game game = Game.getInstance();
        //calling play method from game class.
        game.play();
    }
}
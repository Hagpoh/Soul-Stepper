package com.groovin.client;

import com.groovin.gameSetup.Game;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        //initiating game class
        Game game = new Game();
        //calling play method from game class.
        game.play();
    }
}
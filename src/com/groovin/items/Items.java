package com.groovin.items;

import com.groovin.character.Player;
import com.groovin.gameSetup.JSONReader;

public abstract class Items {

    //would let player use health kit and mj jacket to increase his health
    // method to allow the player to use and item once it's in their inventory

    String name;
    String description;
    JSONReader jsonReader = new JSONReader();

    public Items getItems(int i) {
        return jsonReader.getItems()[i];
    }

    public abstract String useItem(String name, Player player);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
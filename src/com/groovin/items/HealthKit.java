package com.groovin.items;

import com.groovin.character.Player;
import com.groovin.gameSetup.JSONReader;

public class HealthKit extends Items{

    public HealthKit getHealthKit() {
        return (HealthKit) getItems(0);
    }

    @Override
    public String useItem(String name, Player player) {
            player.useHealthKit();
            return player.currentHealth() + "\n" + getDescription() + "\n" + player.getHealth();
    }
}

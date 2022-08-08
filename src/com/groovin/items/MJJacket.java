package com.groovin.items;

import com.groovin.character.Player;
import com.groovin.gameSetup.JSONReader;

public class MJJacket extends Items{

    public MJJacket getMJJacket() {
       return (MJJacket) getItems(1);
    }

    @Override
    public String useItem(String name, Player player) {
        player.setHealth(300);
        return  getDescription() + "\n" + player.getHealth();
    }

}

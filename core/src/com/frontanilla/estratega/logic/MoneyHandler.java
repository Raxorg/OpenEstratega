package com.frontanilla.estratega.logic;

import com.frontanilla.estratega.Player;
import com.frontanilla.estratega.stuff.GameStuff;

public class MoneyHandler {

    private GameStuff stuff;

    public void updateMoneyText(Player player) {
        stuff.getMoneyText().setText(player.getMoney() + "$");
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
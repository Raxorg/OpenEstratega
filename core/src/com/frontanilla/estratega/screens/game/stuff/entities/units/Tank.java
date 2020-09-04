package com.frontanilla.estratega.screens.game.stuff.entities.units;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.estratega.Player;
import com.frontanilla.estratega.screens.game.stuff.Cell;

public class Tank extends Unit {

    public Tank(Player owner, Cell cell, Sprite sprite) {
        super(owner, sprite, cell);
    }

    public void shoot() {
        // TODO
    }
}
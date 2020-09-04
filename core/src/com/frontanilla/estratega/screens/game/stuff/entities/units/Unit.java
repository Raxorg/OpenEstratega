package com.frontanilla.estratega.screens.game.stuff.entities.units;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.estratega.Player;
import com.frontanilla.estratega.screens.game.stuff.Cell;
import com.frontanilla.estratega.screens.game.stuff.entities.Cellable;

public class Unit extends Cellable {

    public Unit(Player owner, Sprite sprite, Cell cell) {
        super(owner, sprite, cell);
    }
}
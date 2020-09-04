package com.frontanilla.estratega.screens.game.stuff.entities.structures;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.estratega.Player;
import com.frontanilla.estratega.screens.game.stuff.Cell;
import com.frontanilla.estratega.screens.game.stuff.entities.Cellable;

public abstract class Structure extends Cellable {

    public Structure(Player owner, Sprite sprite, Cell cell) {
        super(owner, sprite, cell);
    }
}
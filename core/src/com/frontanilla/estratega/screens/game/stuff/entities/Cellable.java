package com.frontanilla.estratega.screens.game.stuff.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.estratega.Player;
import com.frontanilla.estratega.screens.game.stuff.Cell;

public abstract class Cellable extends Entity {

    private Cell cell;

    public Cellable(Player owner, Sprite sprite, Cell cell) {
        super(owner, sprite);
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
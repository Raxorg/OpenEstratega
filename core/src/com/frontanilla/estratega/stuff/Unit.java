package com.frontanilla.estratega.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.estratega.Player;

public class Unit extends Entity {

    private Cell cell;

    public Unit(Player owner, Cell cell, Sprite sprite) {
        super(owner, sprite);
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }
}
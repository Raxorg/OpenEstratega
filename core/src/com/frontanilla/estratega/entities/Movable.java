package com.frontanilla.estratega.entities;

import com.frontanilla.estratega.core.Faction;

public abstract class Movable extends OldEntity {
    protected float xPos;
    protected float yPos;

    public abstract void move();

    protected Movable(float xPos, float yPos, Faction f) {
        this.faction = f;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public float getXPos() {
        return this.xPos;
    }

    public float getYPos() {
        return this.yPos;
    }
}
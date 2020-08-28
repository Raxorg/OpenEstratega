package com.frontanilla.estratega.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.estratega.core.Faction;

public abstract class OldEntity {
    protected int cost;
    protected Faction faction;
    protected int health;
    protected TextureRegion region;
    protected int rotation;

    public abstract void onBulletCollision();

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public Faction getFaction() {
        return this.faction;
    }

    public int getCost() {
        return this.cost;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getRotation() {
        return this.rotation;
    }

    public void setRegion(TextureRegion r) {
        this.region = r;
    }

    public TextureRegion getRegion() {
        return this.region;
    }
}
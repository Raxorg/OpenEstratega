package com.frontanilla.estratega.screens.game.stuff.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.frontanilla.estratega.Player;

public class Bullet extends Entity {

    private Vector2 velocity;

    public Bullet(Player owner, Sprite sprite) {
        super(owner, sprite);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
}
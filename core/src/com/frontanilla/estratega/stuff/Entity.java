package com.frontanilla.estratega.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.frontanilla.estratega.Player;

public abstract class Entity extends Sprite {

    private Player owner;

    public Entity(Player owner, Sprite sprite) {
        super(sprite);
        this.owner = owner;
        setColor(owner.getColor());
    }

    public boolean collides(Rectangle otherRectangle) {
        return getBoundingRectangle().overlaps(otherRectangle);
    }

    public Player getOwner() {
        return owner;
    }
}
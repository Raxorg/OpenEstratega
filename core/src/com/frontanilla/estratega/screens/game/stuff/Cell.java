package com.frontanilla.estratega.screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.estratega.screens.game.stuff.entities.Entity;

public class Cell extends Sprite {

    private com.frontanilla.estratega.screens.game.stuff.entities.Entity entity;

    public Cell(Sprite sprite) {
        super(sprite);
    }

    public com.frontanilla.estratega.screens.game.stuff.entities.Entity getEntity() {
        return entity;
    }

    public boolean isEmpty() {
        return entity == null;
    }

    public boolean contains(float x, float y) {
        return getBoundingRectangle().contains(x, y);
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
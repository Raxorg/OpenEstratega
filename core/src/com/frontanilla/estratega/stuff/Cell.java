package com.frontanilla.estratega.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Cell extends Sprite {

    private Entity entity;

    public Cell(Sprite sprite) {
        super(sprite);
    }

    public Entity getEntity() {
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
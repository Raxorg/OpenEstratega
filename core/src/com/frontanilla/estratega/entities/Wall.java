package com.frontanilla.estratega.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.estratega.core.OldCell;
import com.frontanilla.estratega.core.Faction;
import com.frontanilla.estratega.core.Globals;

public class Wall extends NonMovable {
    private static TextureRegion classRegion;

    public Wall(OldCell c, Faction f) {
        super(c, f);
        this.health = 2;
        this.region = classRegion;
        this.cost = 2;
    }

    public void onBulletCollision() {
        this.health--;
        this.region = new TextureRegion(Globals.TextureHolder.units, 64, 32, 32, 32); // 64 -> 32
        if (this.health == 1) {
            this.region = new TextureRegion(Globals.TextureHolder.units, 64, 32, 32, 32);
        }
        if (this.health == 0) {
            this.oldCell.removeUnit();
        }
    }

    public static void setClassRegion(TextureRegion region) {
        classRegion = region;
    }

    public static TextureRegion getClassRegion() {
        return classRegion;
    }
}
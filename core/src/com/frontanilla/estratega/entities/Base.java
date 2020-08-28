package com.frontanilla.estratega.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.estratega.core.OldCell;
import com.frontanilla.estratega.core.Faction;
import com.frontanilla.estratega.core.Globals;

public class Base extends NonMovable {
    private static TextureRegion classRegion;

    public Base(OldCell c, Faction f) {
        super(c, f);
        this.health = 3;
        this.region = classRegion;
        this.cost = 0;
    }

    public void onBulletCollision() {
        this.health--;
        this.region = new TextureRegion(Globals.TextureHolder.units, 32, 64, 32, 32);
        if (this.health == 1) {
            this.region = new TextureRegion(Globals.TextureHolder.units, 64, 64, 32, 32);
        }
        if (this.health == 0) {
            this.oldCell.removeUnit();
            this.faction.defeat();
        }
    }

    public static void setClassRegion(TextureRegion region) {
        classRegion = region;
    }

    public static TextureRegion getClassRegion() {
        return classRegion;
    }
}
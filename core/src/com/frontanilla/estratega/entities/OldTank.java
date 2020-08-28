package com.frontanilla.estratega.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.estratega.core.OldCell;
import com.frontanilla.estratega.core.Faction;
import com.frontanilla.estratega.core.Globals;

public class OldTank extends NonMovable {
    private static TextureRegion classRegion;

    public OldTank(OldCell c, Faction f) {
        super(c, f);
        this.region = classRegion;
        this.cost = 2;
    }

    public void fire() {
        Globals.SoundHolder.fireBullet.play();
        this.faction.addBullet(new Bullet((float) this.oldCell.getXPos(), (float) this.oldCell.getYPos(), this));
    }

    public void onBulletCollision() {
        this.oldCell.removeUnit();
    }

    public static void setClassRegion(TextureRegion region) {
        classRegion = region;
    }

    public static TextureRegion getClassRegion() {
        return classRegion;
    }
}
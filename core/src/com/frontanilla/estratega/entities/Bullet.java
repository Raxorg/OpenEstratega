package com.frontanilla.estratega.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.estratega.core.Globals;
import com.frontanilla.estratega.core.Turn;

public class Bullet extends Movable {
    private static TextureRegion classRegion;

    public Bullet(float xPos, float yPos, OldEntity t) {
        super(xPos, yPos, t.getFaction());
        this.rotation = t.getRotation();
        this.region = classRegion;
    }

    public void move() {
        this.xPos = (float) (((double) this.xPos) + (Math.cos((((double) this.rotation) * Math.PI) / 180.0d) * 0.07500000298023224d));
        this.yPos = (float) (((double) this.yPos) + (Math.sin((((double) this.rotation) * Math.PI) / 180.0d) * 0.07500000298023224d));
        if (((double) this.xPos) > ((double) Globals.numColumns) - 0.5d || this.xPos < -1.0f || this.yPos > 9.0f || this.yPos < -1.0f) {
            this.faction.removeBullet(this);
        }
    }

    public void onBulletCollision() {
        Turn.faction.removeBullet(this);
        Globals.SoundHolder.destroy.play();
    }

    public static void setClassRegion(TextureRegion region) {
        classRegion = region;
    }

    public static TextureRegion getClassRegion() {
        return classRegion;
    }
}

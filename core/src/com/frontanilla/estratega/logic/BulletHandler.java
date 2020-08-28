package com.frontanilla.estratega.logic;

import com.frontanilla.estratega.stuff.Bullet;
import com.frontanilla.estratega.stuff.Entity;
import com.frontanilla.estratega.stuff.GameStuff;

import static com.frontanilla.estratega.Constants.BULLET_SPEED;

public class BulletHandler {

    private GameStuff stuff;

    public void update(float delta) {
        for (int i = 0; i < stuff.getEntities().size; i++) {
            Entity entity = stuff.getEntities().get(i);
            if (entity instanceof Bullet) {
                Bullet bullet = (Bullet) entity;
                bullet.translate(BULLET_SPEED * delta, 0f);
            }
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
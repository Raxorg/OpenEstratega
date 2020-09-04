package com.frontanilla.estratega.screens.game.logic;

import com.frontanilla.estratega.screens.game.stuff.entities.Bullet;
import com.frontanilla.estratega.screens.game.stuff.entities.Entity;
import com.frontanilla.estratega.screens.game.stuff.GameStuff;

import static com.frontanilla.estratega.Constants.BULLET_SPEED;

public class BulletHandler {

    private GameStuff stuff;

    public void update(float delta) {
        for (int i = 0; i < stuff.getEntities().size; i++) {
            Entity entity = stuff.getEntities().get(i);
            if (entity instanceof Bullet) {
                Bullet bullet = (Bullet) entity;
                bullet.translate(BULLET_SPEED * bullet.getVelocity().x * delta, BULLET_SPEED * bullet.getVelocity().y * delta);
            }
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
package com.frontanilla.estratega.logic;

import com.frontanilla.estratega.GameAssets;
import com.frontanilla.estratega.stuff.AnimationWithTime;
import com.frontanilla.estratega.stuff.Bullet;
import com.frontanilla.estratega.stuff.Entity;
import com.frontanilla.estratega.stuff.GameStuff;
import com.frontanilla.estratega.stuff.Tank;

public class CollisionHandler {

    private GameAssets assets;
    private GameStuff stuff;

    public void update() {
        stuff.getEntities().begin();
        for (int i = 0; i < stuff.getEntities().size; i++) {
            Entity entity = stuff.getEntities().get(i);
            if (entity instanceof Bullet) {
                for (int j = 0; j < stuff.getEntities().size; j++) {
                    Entity anotherEntity = stuff.getEntities().get(j);
                    if (anotherEntity instanceof Tank) {
                        boolean sameTeam = entity.getOwner() == anotherEntity.getOwner();
                        boolean collides = entity.collides(anotherEntity.getBoundingRectangle());
                        if (collides && !sameTeam) {
                            collision(entity, anotherEntity);
                        }
                    }
                }
            }
        }
        stuff.getEntities().end();
    }

    private void collision(Entity entity, Entity anotherEntity) {
        stuff.getEntities().removeValue(anotherEntity, true);
        stuff.getEntities().removeValue(entity, true);
        ((Tank) anotherEntity).getCell().setEntity(null);
        AnimationWithTime animationWithTime = new AnimationWithTime(assets.getExplosionAnimation());
        animationWithTime.setPosition(anotherEntity.getX(), anotherEntity.getY());
        stuff.getExplosionAnimations().add(animationWithTime);
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
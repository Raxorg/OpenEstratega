package com.frontanilla.estratega.screens.game.logic;

import com.frontanilla.estratega.screens.game.GameAssets;
import com.frontanilla.estratega.screens.game.stuff.AnimationWithTime;
import com.frontanilla.estratega.screens.game.stuff.GameStuff;
import com.frontanilla.estratega.screens.game.stuff.entities.Bullet;
import com.frontanilla.estratega.screens.game.stuff.entities.Cellable;
import com.frontanilla.estratega.screens.game.stuff.entities.Entity;
import com.frontanilla.estratega.screens.game.stuff.entities.structures.Structure;
import com.frontanilla.estratega.screens.game.stuff.entities.units.Unit;

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
                    // Is it a unit?
                    if (anotherEntity instanceof Unit) {
                        boolean sameTeam = entity.getOwner() == anotherEntity.getOwner();
                        boolean collides = entity.collides(anotherEntity.getBoundingRectangle());
                        if (collides && !sameTeam) {
                            collision(entity, anotherEntity);
                        }
                        // Is it a structure?
                    } else if (anotherEntity instanceof Structure) {
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
        ((Cellable) anotherEntity).getCell().setEntity(null);
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
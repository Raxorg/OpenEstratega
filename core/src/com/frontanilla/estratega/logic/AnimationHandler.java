package com.frontanilla.estratega.logic;

import com.frontanilla.estratega.stuff.AnimationWithTime;
import com.frontanilla.estratega.stuff.GameStuff;

public class AnimationHandler {

    private GameStuff stuff;

    public void update(float delta) {
        stuff.getExplosionAnimations().begin();
        for (int i = 0; i < stuff.getExplosionAnimations().size; i++) {
            AnimationWithTime animation = stuff.getExplosionAnimations().get(i);
            animation.getAnimation().getKeyFrame(animation.getTime());
            animation.setTime(animation.getTime() + delta);
            if (animation.getAnimation().isAnimationFinished(animation.getTime())) {
                stuff.getExplosionAnimations().removeValue(animation, true);
            }
        }
        stuff.getExplosionAnimations().end();
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
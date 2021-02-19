package com.frontanilla.estratega.screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AnimationWithTime {

    private final Animation<Sprite> animation;
    private float time;

    public AnimationWithTime(Animation<Sprite> originalAnimation) {
        Sprite[] animationSprites = new Sprite[originalAnimation.getKeyFrames().length];
        for (int i = 0; i < animationSprites.length; i++) {
            animationSprites[i] = new Sprite(originalAnimation.getKeyFrames()[i]);
        }
        animation = new Animation<>(originalAnimation.getFrameDuration(), animationSprites);
    }

    public Animation<Sprite> getAnimation() {
        return animation;
    }

    public void setPosition(float x, float y) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setPosition(x, y);
        }
    }

    public void setSize(float size) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setSize(size, size);
        }
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
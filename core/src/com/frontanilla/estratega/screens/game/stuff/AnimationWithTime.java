package com.frontanilla.estratega.screens.game.stuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Timer;

import static com.frontanilla.estratega.Constants.CELL_SIZE;

public class AnimationWithTime {

    private Animation<Sprite> animation;
    private float time;

    public AnimationWithTime(Animation<Sprite> animation) {
        this.animation = animation;
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setSize(CELL_SIZE, CELL_SIZE);
        }
    }

    public Animation<Sprite> getAnimation() {
        return animation;
    }

    public void setPosition(float x, float y) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setPosition(x, y);
        }
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
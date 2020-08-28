package com.frontanilla.estratega.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.estratega.core.Faction;
import com.frontanilla.estratega.core.Globals;

public class WinnerScene implements MyScene {
    private static Color winnerColor;
    private SpriteBatch batch;

    public WinnerScene(SpriteBatch batch) {
        this.batch = batch;
    }

    public static void setWinner(Faction f) {
        winnerColor = f.getColor();
    }

    public void render() {
        this.batch.begin();
        this.batch.setColor(winnerColor);
        this.batch.draw(Globals.TextureHolder.winnerLabel, 0.0f, 0.0f, (float) Gdx.graphics.getWidth(), (float) Globals.screenHeight);
        this.batch.end();
    }
}

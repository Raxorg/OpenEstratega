package com.frontanilla.estratega.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.frontanilla.estratega.core.Globals;
import com.frontanilla.estratega.core.InputManager;

public class MenuScene implements MyScene {
    private SpriteBatch batch;

    public MenuScene(SpriteBatch batch) {
        this.batch = batch;
    }

    public void render() {
        this.batch.begin();
        this.batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.batch.draw(Globals.TextureHolder.menu, 0.0f, 0.0f, (float) Gdx.graphics.getWidth(), (float) Globals.screenHeight);
        this.batch.draw(Globals.TextureHolder.frame, (float) ((Gdx.graphics.getWidth() / 2) - (Globals.screenHeight / 6)), (float) (Globals.screenHeight / 3), (float) (Globals.screenHeight / 3), (float) (Globals.screenHeight / 3));
        String numberOfTeams = InputManager.getInstance().getFactionsOnMenu() + "";
        Globals.FontHolder.teamsNumbers.draw(
                batch,
                numberOfTeams,
                (float) ((Gdx.graphics.getWidth() / 2) - (((Globals.screenHeight / 100) * 9) / (2 / numberOfTeams.length()))),
                (float) ((Globals.screenHeight / 2) + ((Globals.screenHeight / 100) * 8)),
                (float) Gdx.graphics.getWidth(),
                Align.left,
                true);
        this.batch.draw(Globals.TextureHolder.playButton, (float) ((Gdx.graphics.getWidth() / 2) - (Globals.screenHeight / 6)), (float) (Globals.screenHeight / 8), (float) (Globals.screenHeight / 3), (float) (Globals.screenHeight / 6));
        this.batch.draw(Globals.TextureHolder.teamsLabel, (float) ((Gdx.graphics.getWidth() / 2) - (Globals.screenHeight / 6)), ((float) Globals.screenHeight) * 0.75f, (float) (Globals.screenHeight / 3), (float) (Globals.screenHeight / 6));
        for (int i = 0; i < InputManager.getInstance().getFactionsOnMenu(); i++) {
            float columnX;
            float columnY;
            if (i <= 2) {
                columnX = (float) ((Gdx.graphics.getWidth() / 8) + (Globals.screenHeight / 20));
                columnY = (((float) Globals.screenHeight) * 0.25f) + ((((float) Globals.screenHeight) * 0.2f) * ((float) i));
            } else {
                columnX = (float) (((Gdx.graphics.getWidth() / 8) * 7) - ((Globals.screenHeight / 20) * 3));
                columnY = (((float) Globals.screenHeight) * 0.25f) + ((((float) Globals.screenHeight) * 0.2f) * ((float) (i - 3)));
            }
            this.batch.setColor(Globals.ColorHolder.colorsSelected[i]);
            this.batch.draw(Globals.TextureHolder.colorFrame, columnX, columnY, (float) (Globals.screenHeight / 10), (float) (Globals.screenHeight / 10));
        }
        this.batch.end();
    }
}

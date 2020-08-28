package com.frontanilla.estratega;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.estratega.stuff.AnimationWithTime;
import com.frontanilla.estratega.stuff.GameStuff;

import static com.frontanilla.estratega.Constants.COLUMNS;
import static com.frontanilla.estratega.Constants.ROWS;

public class GameRenderer {

    private GameScreen screen;
    private GameStuff stuff;
    // Rendering related
    private SpriteBatch spriteBatch;

    public GameRenderer() {
        spriteBatch = new SpriteBatch();
    }

    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.8f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.setProjectionMatrix(screen.getCamera().combined);

        spriteBatch.begin();
        // Render the cells "The grid"
        for (int column = 0; column < COLUMNS; column++) {
            for (int row = 0; row < ROWS; row++) {
                stuff.getCells()[column][row].draw(spriteBatch);
            }
        }
        // Render the entities "Bullets, tanks etc"
        for (int i = 0; i < stuff.getEntities().size; i++) {
            stuff.getEntities().get(i).draw(spriteBatch);
        }
        // Render the explosion animations
        for (int i = 0; i < stuff.getExplosionAnimations().size; i++) {
            AnimationWithTime animationWithTime = stuff.getExplosionAnimations().get(i);
            animationWithTime.getAnimation().getKeyFrame(animationWithTime.getTime()).draw(spriteBatch);
        }
        // Render the money
        stuff.getMoneyText().draw(spriteBatch);

        spriteBatch.end();
    }

    public void setScreen(GameScreen screen) {
        this.screen = screen;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
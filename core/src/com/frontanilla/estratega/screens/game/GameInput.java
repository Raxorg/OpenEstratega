package com.frontanilla.estratega.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.frontanilla.estratega.screens.game.logic.GameLogic;

public class GameInput extends InputAdapter {

    private GameLogic logic;
    private GameScreen screen;
    // Input related
    private Vector3 unprojected;

    public GameInput() {
        unprojected = new Vector3();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (pointer != 0) {
            return false;
        }
        unprojected = screen.getCamera().unproject(new Vector3(screenX, screenY, 0f));
        logic.getInputHandler().touchDown(unprojected.x, unprojected.y);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (pointer != 0) {
            return false;
        }
        unprojected = screen.getCamera().unproject(new Vector3(screenX, screenY, 0f));
        logic.getInputHandler().touchUp(unprojected.x, unprojected.y);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (pointer != 0) {
            return false;
        }
        unprojected = screen.getCamera().unproject(new Vector3(screenX, screenY, 0f));
        logic.getInputHandler().touchDragged(unprojected.x, unprojected.y);
        return true;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setScreen(GameScreen screen) {
        this.screen = screen;
    }
}
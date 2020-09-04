package com.frontanilla.estratega.screens.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.frontanilla.estratega.screens.game.logic.GameLogic;

import static com.frontanilla.estratega.Constants.CAMERA_HEIGHT;
import static com.frontanilla.estratega.Constants.CAMERA_WIDTH;

public class GameScreen extends ScreenAdapter {

    private GameLogic logic;
    private GameRenderer renderer;
    // Screen related
    private OrthographicCamera camera;

    public void initializeCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
    }

    @Override
    public void render(float delta) {
        logic.update(delta);
        renderer.render();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setRenderer(GameRenderer renderer) {
        this.renderer = renderer;
    }
}
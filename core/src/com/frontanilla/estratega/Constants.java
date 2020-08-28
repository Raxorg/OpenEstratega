package com.frontanilla.estratega;

import com.badlogic.gdx.Gdx;

public class Constants {

    // Camera
    public static final float CAMERA_HEIGHT = 1000f;
    public static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public static final float RATIO = SCREEN_WIDTH / SCREEN_HEIGHT;
    public static final float CAMERA_WIDTH = CAMERA_HEIGHT * RATIO;
    // Grid
    public static final int COLUMNS = 10;
    public static final int ROWS = 10;
    public static final float CELL_SIZE = CAMERA_HEIGHT / 10f;
    // Tank
    public static final int BULLET_SPEED = 500;
}
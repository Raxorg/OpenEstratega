package com.frontanilla.estratega.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.frontanilla.estratega.core.EstrategaGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1000;
        config.height = config.width / 2;
        config.forceExit = false;
        new LwjglApplication(new EstrategaGame(), config);
    }
}

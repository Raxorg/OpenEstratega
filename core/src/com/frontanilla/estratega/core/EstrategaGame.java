package com.frontanilla.estratega.core;

import com.badlogic.gdx.Game;
import com.frontanilla.estratega.GameInput;
import com.frontanilla.estratega.GameRenderer;
import com.frontanilla.estratega.GameScreen;
import com.frontanilla.estratega.stuff.GameStuff;
import com.frontanilla.estratega.GameAssets;
import com.frontanilla.estratega.logic.GameLogic;

public class EstrategaGame extends Game {

    public void create() {
        GameAssets assets = new GameAssets();
        GameInput input = new GameInput();
        GameLogic logic = new GameLogic();
        GameScreen screen = new GameScreen();
        GameRenderer renderer = new GameRenderer();
        GameStuff stuff = new GameStuff();

        input.setLogic(logic);
        input.setScreen(screen);
        logic.setAssets(assets);
        logic.setStuff(stuff);
        renderer.setScreen(screen);
        renderer.setStuff(stuff);
        screen.setLogic(logic);
        screen.setRenderer(renderer);
        stuff.setAssets(assets);

        assets.queueAssetLoading();
        assets.finishLoadingAssets();
        assets.initializeAssets();
        screen.initializeCamera();
        stuff.initializeStuff();

        logic.initialLogic();

        setScreen(screen);
    }
}
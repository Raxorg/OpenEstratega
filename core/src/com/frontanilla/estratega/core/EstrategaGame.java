package com.frontanilla.estratega.core;

import com.badlogic.gdx.Game;
import com.frontanilla.estratega.screens.game.GameInput;
import com.frontanilla.estratega.screens.game.GameRenderer;
import com.frontanilla.estratega.screens.game.GameScreen;
import com.frontanilla.estratega.screens.game.stuff.GameStuff;
import com.frontanilla.estratega.screens.game.GameAssets;
import com.frontanilla.estratega.screens.game.logic.GameLogic;

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
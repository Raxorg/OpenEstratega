package com.frontanilla.estratega.logic;

import com.frontanilla.estratega.GameAssets;
import com.frontanilla.estratega.stuff.GameStuff;

public class GameLogic {

    private AnimationHandler animationHandler;
    private BulletHandler bulletHandler;
    private CollisionHandler collisionHandler;
    private InputHandler inputHandler;
    private MoneyHandler moneyHandler;
    private TurnHandler turnHandler;
    // More helpers xD

    public GameLogic() {
        animationHandler = new AnimationHandler();
        bulletHandler = new BulletHandler();
        collisionHandler = new CollisionHandler();
        inputHandler = new InputHandler();
        moneyHandler = new MoneyHandler();
        turnHandler = new TurnHandler();

        inputHandler.setLogic(this);
    }

    public void initialLogic() {
        turnHandler.init();
    }

    public void update(float delta) {
        animationHandler.update(delta);
        bulletHandler.update(delta);
        collisionHandler.update();
    }

    public void setAssets(GameAssets assets) {
        collisionHandler.setAssets(assets);
        inputHandler.setAssets(assets);
    }

    public void setStuff(GameStuff stuff) {
        animationHandler.setStuff(stuff);
        bulletHandler.setStuff(stuff);
        collisionHandler.setStuff(stuff);
        inputHandler.setStuff(stuff);
        moneyHandler.setStuff(stuff);
        turnHandler.setStuff(stuff);
        // More set stuffs xD
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public BulletHandler getBulletHandler() {
        return bulletHandler;
    }

    public MoneyHandler getMoneyHandler() {
        return moneyHandler;
    }

    public TurnHandler getTurnHandler() {
        return turnHandler;
    }
}
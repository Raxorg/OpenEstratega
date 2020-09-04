package com.frontanilla.estratega.screens.game.logic;

import com.frontanilla.estratega.screens.game.GameAssets;
import com.frontanilla.estratega.screens.game.stuff.GameStuff;

public class GameLogic {

    // Logic helpers
    private AnimationHandler animationHandler;
    private BaseHandler baseHandler;
    private BulletHandler bulletHandler;
    private CollisionHandler collisionHandler;
    private EntitySpawnHandler entitySpawnHandler;
    private InputHandler inputHandler;
    private MoneyHandler moneyHandler;
    private TurnHandler turnHandler;
    // More helpers xD

    public GameLogic() {
        animationHandler = new AnimationHandler();
        baseHandler = new BaseHandler();
        bulletHandler = new BulletHandler();
        collisionHandler = new CollisionHandler();
        entitySpawnHandler = new EntitySpawnHandler();
        inputHandler = new InputHandler();
        moneyHandler = new MoneyHandler();
        turnHandler = new TurnHandler();

        baseHandler.setLogic(this);
        entitySpawnHandler.setLogic(this);
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
        baseHandler.setAssets(assets);
        collisionHandler.setAssets(assets);
        entitySpawnHandler.setAssets(assets);
    }

    public void setStuff(GameStuff stuff) {
        animationHandler.setStuff(stuff);
        baseHandler.setStuff(stuff);
        bulletHandler.setStuff(stuff);
        collisionHandler.setStuff(stuff);
        entitySpawnHandler.setStuff(stuff);
        inputHandler.setStuff(stuff);
        moneyHandler.setStuff(stuff);
        turnHandler.setStuff(stuff);
        // More set stuffs xD
    }

    public BaseHandler getBaseHandler() {
        return baseHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public BulletHandler getBulletHandler() {
        return bulletHandler;
    }

    public EntitySpawnHandler getEntitySpawnHandler() {
        return entitySpawnHandler;
    }

    public MoneyHandler getMoneyHandler() {
        return moneyHandler;
    }

    public TurnHandler getTurnHandler() {
        return turnHandler;
    }
}
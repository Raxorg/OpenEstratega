package com.frontanilla.estratega.screens.game.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.frontanilla.estratega.Player;
import com.frontanilla.estratega.screens.game.GameAssets;
import com.frontanilla.estratega.screens.game.stuff.entities.Bullet;
import com.frontanilla.estratega.screens.game.stuff.Cell;
import com.frontanilla.estratega.screens.game.stuff.GameStuff;
import com.frontanilla.estratega.screens.game.stuff.entities.units.Tank;

import static com.frontanilla.estratega.Constants.CELL_SIZE;

public class EntitySpawnHandler {

    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public void spawnTank(Cell cell) {
        Player currentPlayer = logic.getTurnHandler().getCurrentPlayer();
        if (currentPlayer.getMoney() >= 3) {
            // Spend money
            currentPlayer.setMoney(currentPlayer.getMoney() - 3);
        } else {
            return;
        }
        Tank tank = new Tank(currentPlayer, cell, assets.getTank());
        tank.setX(cell.getX());
        tank.setY(cell.getY());
        tank.setSize(CELL_SIZE, CELL_SIZE);
        tank.setOriginCenter();
        stuff.getEntities().add(tank);
        cell.setEntity(tank);
        assets.getShoutingSoldier().play();
        logic.getMoneyHandler().updateMoneyText(logic.getTurnHandler().getCurrentPlayer());
    }

    public void spawnBullet(Tank tank) {
        Bullet bullet = new Bullet(tank.getOwner(), assets.getBullet());
        bullet.setSize(CELL_SIZE / 4f, CELL_SIZE / 4f);
        bullet.setOriginCenter();
        bullet.setOriginBasedPosition(tank.getX() + tank.getWidth() / 2f, tank.getY() + tank.getHeight() / 2f);
        bullet.setRotation(tank.getRotation());
        bullet.setVelocity(new Vector2(MathUtils.cosDeg(tank.getRotation()), MathUtils.sinDeg(tank.getRotation())));
        stuff.getEntities().add(bullet);
        assets.getExplosion().play();
        bullet.setColor(tank.getColor());
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
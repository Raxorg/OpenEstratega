package com.frontanilla.estratega.logic;

import com.frontanilla.estratega.GameAssets;
import com.frontanilla.estratega.Player;
import com.frontanilla.estratega.stuff.Bullet;
import com.frontanilla.estratega.stuff.Cell;
import com.frontanilla.estratega.stuff.GameStuff;
import com.frontanilla.estratega.stuff.Tank;

import static com.frontanilla.estratega.Constants.CELL_SIZE;
import static com.frontanilla.estratega.Constants.COLUMNS;
import static com.frontanilla.estratega.Constants.ROWS;

public class InputHandler {

    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public void touchUp(float x, float y) {
        for (int column = 0; column < COLUMNS; column++) {
            for (int row = 0; row < ROWS; row++) {
                Cell cell = stuff.getCells()[column][row];
                if (cell.contains(x, y) && cell.isEmpty()) {
                    spawnTank(cell);
                    return;
                } else if (cell.contains(x, y) && cell.getEntity() instanceof Tank) {
                    Bullet bullet = new Bullet(cell.getEntity().getOwner(), assets.getBullet());
                    bullet.setX(cell.getX());
                    bullet.setY(cell.getY());
                    bullet.setSize(CELL_SIZE, CELL_SIZE);
                    stuff.getEntities().add(bullet);
                    assets.getExplosion().play();
                    bullet.setColor(cell.getEntity().getColor());
                }
            }
        }
    }

    private void spawnTank(Cell cell) {
        Player currentPlayer = logic.getTurnHandler().getCurrentPlayer();
        Tank tank = new Tank(currentPlayer, cell, assets.getTank());
        tank.setX(cell.getX());
        tank.setY(cell.getY());
        tank.setSize(CELL_SIZE, CELL_SIZE);
        stuff.getEntities().add(tank);
        cell.setEntity(tank);
        assets.getShoutingSoldier().play();
        // Spend money
        currentPlayer.setMoney(currentPlayer.getMoney() - 3);
        // Pass the turn
        logic.getTurnHandler().passTurn();
        logic.getMoneyHandler().updateMoneyText(logic.getTurnHandler().getCurrentPlayer());
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
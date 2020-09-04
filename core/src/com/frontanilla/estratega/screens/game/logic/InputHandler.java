package com.frontanilla.estratega.screens.game.logic;

import com.badlogic.gdx.math.MathUtils;
import com.frontanilla.estratega.screens.game.stuff.Cell;
import com.frontanilla.estratega.screens.game.stuff.GameStuff;
import com.frontanilla.estratega.screens.game.stuff.entities.Entity;
import com.frontanilla.estratega.screens.game.stuff.entities.units.Tank;

import static com.frontanilla.estratega.Constants.COLUMNS;
import static com.frontanilla.estratega.Constants.ROWS;

public class InputHandler {

    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private Tank chosenTank;

    public void touchDown(float x, float y) {
        for (int i = 0; i < stuff.getEntities().size; i++) {
            Entity entity = stuff.getEntities().get(i);
            if (entity instanceof Tank && entity.contains(x, y)) {
                chosenTank = (Tank) entity;
                return;
            }
        }
        chosenTank = null;
    }

    public void touchUp(float x, float y) {
        if (!logic.getBaseHandler().playerHasBase(logic.getTurnHandler().getCurrentPlayer())) {
            for (int column = 0; column < COLUMNS; column++) {
                for (int row = 0; row < ROWS; row++) {
                    Cell cell = stuff.getCells()[column][row];
                    if (cell.contains(x, y) && cell.isEmpty()) {
                        logic.getBaseHandler().spawnBase(cell);
                    }
                }
            }
            return;
        }

        for (int column = 0; column < COLUMNS; column++) {
            for (int row = 0; row < ROWS; row++) {
                Cell cell = stuff.getCells()[column][row];
                if (cell.contains(x, y) && cell.isEmpty()) {
                    logic.getEntitySpawnHandler().spawnTank(cell);
                    return;
                } else if (cell.contains(x, y) && cell.getEntity() instanceof Tank) {
                    logic.getEntitySpawnHandler().spawnBullet((Tank) cell.getEntity());
                }
            }
        }
        if (stuff.getPassTurnButton().contains(x, y)) {
            // Pass the turn
            logic.getTurnHandler().passTurn();
            logic.getMoneyHandler().updateMoneyText(logic.getTurnHandler().getCurrentPlayer());
            stuff.getPassTurnButton().setColor(logic.getTurnHandler().getCurrentPlayer().getColor());
        }
    }

    public void touchDragged(float x, float y) {
        if (chosenTank == null) {
            return;
        }
        float tankCenterX = chosenTank.getX() + chosenTank.getWidth() / 2f;
        float tankCenterY = chosenTank.getY() + chosenTank.getHeight() / 2f;
        float angle = (float) (MathUtils.atan2(tankCenterY - y, tankCenterX - x) * 180f / MathUtils.PI);
        angle += 180f;
        chosenTank.setRotation(angle);
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
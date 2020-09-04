package com.frontanilla.estratega.screens.game.logic;

import com.frontanilla.estratega.Player;
import com.frontanilla.estratega.screens.game.GameAssets;
import com.frontanilla.estratega.screens.game.stuff.Cell;
import com.frontanilla.estratega.screens.game.stuff.GameStuff;
import com.frontanilla.estratega.screens.game.stuff.entities.structures.Base;
import com.frontanilla.estratega.screens.game.stuff.entities.Entity;

import static com.frontanilla.estratega.Constants.CELL_SIZE;

public class BaseHandler {

    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public void spawnBase(Cell cell) {
        Player currentPlayer = logic.getTurnHandler().getCurrentPlayer();
        Base base = new Base(currentPlayer, assets.getBase(), cell);
        base.setSize(CELL_SIZE, CELL_SIZE);
        base.setPosition(cell.getX(), cell.getY());
        stuff.getEntities().add(base);
        cell.setEntity(base);
        base.setColor(currentPlayer.getColor());
    }

    public boolean playerHasBase(Player player) {
        for (int i = 0; i < stuff.getEntities().size; i++) {
            Entity entity = stuff.getEntities().get(i);
            if (entity instanceof Base) {
                if (entity.getOwner() == player) {
                    return true;
                }
            }
        }
        return false;
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
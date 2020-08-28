package com.frontanilla.estratega.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.frontanilla.estratega.core.OldCell;
import com.frontanilla.estratega.core.Faction;
import com.frontanilla.estratega.core.Globals;
import com.frontanilla.estratega.core.InputManager;
import com.frontanilla.estratega.core.Turn;
import com.frontanilla.estratega.entities.OldTank;
import com.frontanilla.estratega.entities.Wall;

public class GameScene implements MyScene {
    private SpriteBatch batch;

    public GameScene(SpriteBatch batch) {
        this.batch = batch;
    }

    public void render() {
        int i;
        this.batch.begin();
        this.batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        for (i = 0; i < Globals.numColumns; i++) {
            this.batch.draw(Globals.TextureHolder.backGround, ((float) i) * Globals.columnWidth, 0.0f, Globals.columnWidth, (float) Globals.screenHeight);
        }
        for (int a = 0; a < Globals.factions.size; a++) {
            this.batch.setColor((Globals.factions.get(a)).getColor());
            for (i = 0; i < (Globals.factions.get(a)).getControlledOldCells().size(); i++) {
                this.batch.draw(Globals.TextureHolder.transparent, ((float) ((Globals.factions.get(a)).getControlledOldCells().get(i)).getXPos()) * Globals.columnWidth, ((float) ((OldCell) ((Faction) Globals.factions.get(a)).getControlledOldCells().get(i)).getYPos()) * Globals.columnWidth, Globals.columnWidth, Globals.columnWidth);
            }
        }
        Globals.FontHolder.scoreNumbers.setColor(Turn.faction.getColor());
        Globals.FontHolder.scoreNumbers.draw(
                batch,
                Turn.faction.getMoney() + "",
                Globals.gridWidth + (Globals.rightSpaceWidth / 4.0f),
                ((float) Globals.screenHeight) - (Globals.columnWidth / 4.0f),
                (float) Gdx.graphics.getWidth(),
                Align.left,
                true);
        this.batch.setColor(Turn.faction.getColor());
        this.batch.draw(Globals.TextureHolder.scoreFrame, Globals.gridWidth, Globals.columnWidth * 7.0f, Globals.rightSpaceWidth, Globals.columnWidth);
        if (InputManager.buildingTank) {
            this.batch.draw(Globals.TextureHolder.buttonSelected, Globals.gridWidth, 0.0f, Globals.rightSpaceWidth, (Globals.columnWidth * 7.0f) / 3.0f);
        } else {
            this.batch.draw(Globals.TextureHolder.button, Globals.gridWidth, 0.0f, Globals.rightSpaceWidth, (Globals.columnWidth * 7.0f) / 3.0f);
        }
        batch.draw(
                OldTank.getClassRegion(),
                Globals.gridWidth + ((Globals.rightSpaceWidth - Globals.columnWidth) / 2.0f),
                (2.0f * Globals.columnWidth) / 3.0f,
                (float) (Globals.screenHeight / 16),
                (float) (Globals.screenHeight / 16),
                Globals.columnWidth,
                Globals.columnWidth,
                1.0f,
                1.0f,
                90.0f);
        if (InputManager.buildingWall) {
            this.batch.draw(Globals.TextureHolder.buttonSelected, Globals.gridWidth, (Globals.columnWidth * 7.0f) / 3.0f, Globals.rightSpaceWidth, (Globals.columnWidth * 7.0f) / 3.0f);
        } else {
            this.batch.draw(Globals.TextureHolder.button, Globals.gridWidth, (Globals.columnWidth * 7.0f) / 3.0f, Globals.rightSpaceWidth, (Globals.columnWidth * 7.0f) / 3.0f);
        }
        this.batch.draw(Wall.getClassRegion(), Globals.gridWidth + ((Globals.rightSpaceWidth - Globals.columnWidth) / 2.0f), ((Globals.columnWidth * 7.0f) / 3.0f) + ((2.0f * Globals.columnWidth) / 3.0f), (float) (Globals.screenHeight / 16), (float) (Globals.screenHeight / 16), Globals.columnWidth, Globals.columnWidth, 1.0f, 1.0f, 90.0f);
        this.batch.draw(Globals.TextureHolder.button, Globals.gridWidth, (Globals.columnWidth * 14.0f) / 3.0f, Globals.rightSpaceWidth, (Globals.columnWidth * 7.0f) / 3.0f);
        this.batch.draw(Globals.TextureHolder.sword, Globals.gridWidth + ((Globals.rightSpaceWidth - Globals.columnWidth) / 2.0f), ((Globals.columnWidth * 14.0f) / 3.0f) + ((2.0f * Globals.columnWidth) / 3.0f), Globals.columnWidth, Globals.columnWidth);
        for (i = 0; i < Globals.numColumns; i++) {
            for (int j = 0; j < 8; j++) {
                if (!Globals.grid.getCell(i, j).isEmpty()) {
                    this.batch.setColor(Globals.grid.getCell(i, j).getUnit().getFaction().getColor());
                    this.batch.draw(Globals.grid.getCell(i, j).getUnit().getRegion(), ((float) Globals.grid.getCell(i, j).getXPos()) * Globals.columnWidth, ((float) Globals.grid.getCell(i, j).getYPos()) * Globals.columnWidth, (float) (Globals.screenHeight / 16), (float) (Globals.screenHeight / 16), Globals.columnWidth, Globals.columnWidth, 1.0f, 1.0f, (float) Globals.grid.getCell(i, j).getUnit().getRotation());
                }
            }
        }
        this.batch.setColor(Turn.faction.getColor());
        for (i = 0; i < Turn.faction.getBulletList().size(); i++) {
            this.batch.draw((Turn.faction.getBulletList().get(i)).getRegion(), (Turn.faction.getBulletList().get(i)).getXPos() * Globals.columnWidth, (Turn.faction.getBulletList().get(i)).getYPos() * Globals.columnWidth, (float) (Globals.screenHeight / 16), (float) (Globals.screenHeight / 16), Globals.columnWidth, Globals.columnWidth, 1.0f, 1.0f, 0.0f);
            (Turn.faction.getBulletList().get(i)).move();
        }
        this.batch.end();
        if (InputManager.waitingForBullets && Turn.faction.getBulletList().size() == 0) {
            Turn.passTurn();
            InputManager.waitingForBullets = false;
        }
        InputManager.checkForCollisions();
    }
}

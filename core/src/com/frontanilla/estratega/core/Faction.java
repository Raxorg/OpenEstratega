package com.frontanilla.estratega.core;

import com.badlogic.gdx.graphics.Color;
import com.frontanilla.estratega.entities.Base;
import com.frontanilla.estratega.entities.Bullet;
import com.frontanilla.estratega.entities.OldEntity;
import com.frontanilla.estratega.entities.Wall;
import com.frontanilla.estratega.scenes.WinnerScene;

import java.util.ArrayList;
import java.util.List;

public class Faction {
    private boolean basePlaced;
    private ArrayList<Bullet> bulletList = new ArrayList<>();
    private Color color;
    private ArrayList<OldCell> controlledOldCells = new ArrayList<>();
    private int money = 0;
    private List<OldEntity> unitList = new ArrayList<>();

    public Faction(Color color) {
        this.color = color;
    }

    public void addBullet(Bullet b) {
        b.setFaction(this);
        this.bulletList.add(b);
    }

    public void buyUnit(OldEntity u, boolean playSound) {
        if (playSound) {
            if (u instanceof Base) {
                Globals.SoundHolder.buildWall.play();
            } else if (u instanceof Wall) {
                Globals.SoundHolder.buildWall.play();
            } else {
                Globals.SoundHolder.buyTank.play();
            }
        }
        u.setFaction(this);
        this.unitList.add(u);
        this.money -= u.getCost();
        if (u instanceof Wall) {
            recalculateControlledCells();
        }
    }

    private void recalculateControlledCells() {
        this.controlledOldCells = new ArrayList<>();
        int a = 0;
        while (a < getWallsList().size()) {
            int i = 0;
            while (i < 3) {
                int j = 0;
                while (j < 3) {
                    if (((getWallsList().get(a)).getOldCell().getXPos() - 1) + i >= 0 && ((getWallsList().get(a)).getOldCell().getXPos() - 1) + i <= Globals.numColumns - 1 && ((getWallsList().get(a)).getOldCell().getYPos() - 1) + j >= 0 && ((getWallsList().get(a)).getOldCell().getYPos() - 1) + j <= 7 && !this.controlledOldCells.contains(Globals.grid.getCell(((getWallsList().get(a)).getOldCell().getXPos() - 1) + i, ((getWallsList().get(a)).getOldCell().getYPos() - 1) + j))) {
                        this.controlledOldCells.add(Globals.grid.getCell(((getWallsList().get(a)).getOldCell().getXPos() - 1) + i, ((getWallsList().get(a)).getOldCell().getYPos() - 1) + j));
                    }
                    j++;
                }
                i++;
            }
            a++;
        }
    }

    public void defeat() {
        Globals.factions.removeValue(this, true);
        if (Globals.factions.size == 1) {
            Globals.onMatch = false;
            WinnerScene.setWinner(Globals.factions.get(0));
            Globals.onWinnerScreen = true;
        }
    }

    public void removeUnit(OldEntity u) {
        this.unitList.remove(u);
        if (u instanceof Wall) {
            recalculateControlledCells();
        }
    }

    public void removeBullet(Bullet b) {
        this.bulletList.remove(b);
    }

    public Color getColor() {
        return this.color;
    }

    public List<OldEntity> getUnitList() {
        return this.unitList;
    }

    public List<Bullet> getBulletList() {
        return this.bulletList;
    }

    public List<Wall> getWallsList() {
        ArrayList<Wall> wallsList = new ArrayList<>();
        for (int i = 0; i < this.unitList.size(); i++) {
            if (this.unitList.get(i) instanceof Wall) {
                wallsList.add((Wall) this.unitList.get(i));
            }
        }
        return wallsList;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public void setBasePlaced(boolean basePlaced) {
        this.basePlaced = basePlaced;
    }

    public boolean getBasePlaced() {
        return this.basePlaced;
    }

    public List<OldCell> getControlledOldCells() {
        return this.controlledOldCells;
    }
}
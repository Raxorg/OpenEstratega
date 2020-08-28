package com.frontanilla.estratega.core;

import com.frontanilla.estratega.entities.NonMovable;

public class OldCell {
    private Grid grid;
    private NonMovable unit;
    private int xPos;
    private int yPos;

    public OldCell(int xPos, int yPos, Grid g) {
        this.grid = g;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public boolean canPlace(Faction faction) {
        return faction.getControlledOldCells().contains(this);
    }

    public int getXPos() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public boolean isEmpty() {
        return this.unit == null;
    }

    public void setUnit(NonMovable u) {
        unit = u;
        u.setOldCell(this);
        grid.getUsedCells().add(this);
    }

    public NonMovable getUnit() {
        return this.unit;
    }

    public void removeUnit() {
        grid.getUsedCells().removeValue(this, true);
        unit.getFaction().removeUnit(this.unit);
        unit = null;
    }
}
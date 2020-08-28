package com.frontanilla.estratega.core;

import com.badlogic.gdx.utils.DelayedRemovalArray;

import java.lang.reflect.Array;

public class Grid {
    private OldCell[][] grid;
    private DelayedRemovalArray<OldCell> usedCells = new DelayedRemovalArray<>();

    public Grid(int x, int y) {
        this.grid = (OldCell[][]) Array.newInstance(OldCell.class, new int[]{x, y});
        for (int i = 0; i < Globals.numColumns; i++) {
            for (int j = 0; j < 8; j++) {
                this.grid[i][j] = new OldCell(i, j, this);
            }
        }
    }

    public OldCell getCell(int h, int v) {
        return this.grid[h][v];
    }

    public DelayedRemovalArray<OldCell> getUsedCells() {
        return this.usedCells;
    }
}

package com.frontanilla.estratega.entities;

import com.frontanilla.estratega.core.OldCell;
import com.frontanilla.estratega.core.Faction;

public abstract class NonMovable extends OldEntity {
    protected OldCell oldCell;

    public NonMovable(OldCell c, Faction f) {
        this.oldCell = c;
        c.setUnit(this);
        this.faction = f;
    }

    public void setOldCell(OldCell c) {
        this.oldCell = c;
    }

    public OldCell getOldCell() {
        return this.oldCell;
    }
}
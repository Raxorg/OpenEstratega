package com.frontanilla.estratega.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.frontanilla.estratega.entities.Base;
import com.frontanilla.estratega.entities.Bullet;
import com.frontanilla.estratega.entities.OldTank;
import com.frontanilla.estratega.entities.Wall;

public class InputManager implements InputProcessor {
    public static boolean buildingTank = false;
    public static boolean buildingWall = false;
    private static InputManager instance;
    public static boolean waitingForBullets = false;
    private int factionsOnMenu = 2;

    private InputManager() {
    }

    public static InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
        }
        return instance;
    }

    public int getFactionsOnMenu() {
        return this.factionsOnMenu;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenY = Globals.screenHeight - screenY;
        if (Globals.onMenu) {
            return touchUpOnMenu(screenX, screenY);
        }
        if (Globals.onMatch) {
            return touchUpOnGame(screenX, screenY);
        }
        if (Globals.onWinnerScreen) {
            return touchUpOnWinnerScreen(screenX, screenY);
        }
        return false;
    }

    private boolean touchUpOnMenu(int screenX, int screenY) {
        if (((float) screenX) >= ((float) (Gdx.graphics.getWidth() / 2)) - (((float) Gdx.graphics.getHeight()) * 0.15f) && ((float) screenX) < (((float) (Gdx.graphics.getWidth() / 2)) - (((float) Gdx.graphics.getHeight()) * 0.15f)) + (((float) Gdx.graphics.getHeight()) * 0.35f) && ((float) screenY) >= ((float) Gdx.graphics.getHeight()) * 0.35f && ((float) screenY) < (((float) Gdx.graphics.getHeight()) * 0.35f) + (((float) Gdx.graphics.getHeight()) * 0.3f)) {
            if (this.factionsOnMenu < 6) {
                this.factionsOnMenu++;
            } else {
                this.factionsOnMenu = 2;
            }
            return true;
        } else if (screenX >= (Gdx.graphics.getWidth() / 2) - (Globals.screenHeight / 6) && screenX < ((Gdx.graphics.getWidth() / 2) - (Globals.screenHeight / 6)) + (Globals.screenHeight / 3) && screenY >= Globals.screenHeight / 8 && screenY < (Globals.screenHeight / 8) + (Globals.screenHeight / 6)) {
            for (int i = 0; i < this.factionsOnMenu; i++) {
                Globals.factions.add(new Faction(Globals.ColorHolder.colorsSelected[i]));
                Turn.faction = (Faction) Globals.factions.get(0);
            }
            Globals.onMenu = false;
            Globals.onMatch = true;
            return true;
        } else if (screenX >= (Gdx.graphics.getWidth() / 8) + (Globals.screenHeight / 20) && screenX < ((Gdx.graphics.getWidth() / 8) + (Globals.screenHeight / 20)) + (Globals.screenHeight / 10)) {
            int i = 0;
            while (i < this.factionsOnMenu) {
                if (((float) screenY) >= (((float) Globals.screenHeight) * 0.25f) + ((((float) Globals.screenHeight) * 0.2f) * ((float) i)) && ((float) screenY) < ((((float) Globals.screenHeight) * 0.25f) + ((((float) Globals.screenHeight) * 0.2f) * ((float) i))) + ((float) (Globals.screenHeight / 10))) {
                    Globals.ColorHolder.nextColor(i);
                }
                i++;
            }
            return true;
        } else if (screenX < ((Gdx.graphics.getWidth() / 8) * 7) - ((Globals.screenHeight / 20) * 3) || screenX >= (((Gdx.graphics.getWidth() / 8) * 7) - ((Globals.screenHeight / 20) * 3)) + (Globals.screenHeight / 10)) {
            return false;
        } else {
            int i = 3;
            while (i < this.factionsOnMenu) {
                if (((float) screenY) >= (((float) Globals.screenHeight) * 0.25f) + ((((float) Globals.screenHeight) * 0.2f) * ((float) (i - 3))) && ((float) screenY) < ((((float) Globals.screenHeight) * 0.25f) + ((((float) Globals.screenHeight) * 0.2f) * ((float) (i - 3)))) + ((float) (Globals.screenHeight / 10))) {
                    Globals.ColorHolder.nextColor(i);
                }
                i++;
            }
            return true;
        }
    }

    private boolean touchUpOnGame(int screenX, int screenY) {
        if (waitingForBullets) {
            return false;
        }
        int i;
        int posXTouched = (int) (((float) screenX) / Globals.columnWidth);
        int posYTouched = (int) (((float) screenY) / Globals.columnWidth);
        if (Turn.faction.getBasePlaced() && posXTouched > Globals.numColumns - 1) {
            if (screenY <= ((Gdx.graphics.getHeight() / 8) * 7) / 3) {
                buildingTank = !buildingTank;
                buildingWall = false;
            } else if (((double) screenY) <= ((double) ((Gdx.graphics.getHeight() / 8) * 7)) / 1.5d) {
                buildingWall = !buildingWall;
                buildingTank = false;
            } else if (screenY <= (Gdx.graphics.getHeight() / 8) * 7) {
                if (!Turn.firstRound) {
                    for (i = 0; i < Turn.faction.getUnitList().size(); i++) {
                        if (Turn.faction.getUnitList().get(i) instanceof OldTank) {
                            ((OldTank) Turn.faction.getUnitList().get(i)).fire();
                        }
                    }
                }
                waitingForBullets = true;
                buildingTank = false;
                buildingWall = false;
            }
        }
        if (posXTouched <= Globals.numColumns - 1) {
            if (!Globals.grid.getCell(posXTouched, posYTouched).isEmpty()) {
                if ((Globals.grid.getCell(posXTouched, posYTouched).getUnit() instanceof OldTank) && Globals.grid.getCell(posXTouched, posYTouched).getUnit().getFaction() == Turn.faction) {
                    if (Globals.grid.getCell(posXTouched, posYTouched).getUnit().getRotation() == 315) {
                        Globals.grid.getCell(posXTouched, posYTouched).getUnit().setRotation(0);
                    } else {
                        Globals.grid.getCell(posXTouched, posYTouched).getUnit().setRotation(Globals.grid.getCell(posXTouched, posYTouched).getUnit().getRotation() + 45);
                    }
                }
                return true;
            } else if (!Turn.faction.getBasePlaced()) {
                Turn.faction.buyUnit(new Base(Globals.grid.getCell(posXTouched, posYTouched), Turn.faction), true);
                i = 0;
                while (i < 3) {
                    int j = 0;
                    while (j < 3) {
                        if ((posXTouched - 1) + i >= 0 && (posXTouched - 1) + i <= Globals.numColumns - 1 && (posYTouched - 1) + j >= 0 && (posYTouched - 1) + j <= 7 && Globals.grid.getCell((posXTouched - 1) + i, (posYTouched - 1) + j).isEmpty()) {
                            Turn.faction.setMoney(Turn.faction.getMoney() + 2);
                            Turn.faction.buyUnit(new Wall(Globals.grid.getCell((posXTouched - 1) + i, (posYTouched - 1) + j), Turn.faction), false);
                        }
                        j++;
                    }
                    i++;
                }
                Turn.faction.setBasePlaced(true);
                Turn.passTurn();
                return true;
            } else if (Globals.grid.getCell(posXTouched, posYTouched).canPlace(Turn.faction)) {
                if (buildingTank) {
                    if (Turn.faction.getMoney() >= 3) {
                        Turn.faction.buyUnit(new OldTank(Globals.grid.getCell(posXTouched, posYTouched), Turn.faction), true);
                    }
                } else if (buildingWall && Turn.faction.getMoney() >= 2) {
                    Turn.faction.buyUnit(new Wall(Globals.grid.getCell(posXTouched, posYTouched), Turn.faction), true);
                }
            }
        }
        return true;
    }

    private boolean touchUpOnWinnerScreen(int screenX, int screenY) {
        if (((double) screenX) >= ((double) Gdx.graphics.getWidth()) * 0.375d && ((double) screenX) < ((double) Gdx.graphics.getWidth()) * 0.625d && ((double) screenY) >= ((double) Gdx.graphics.getHeight()) * 0.375d && ((double) screenY) < ((double) Gdx.graphics.getHeight()) * 0.625d) {
            Globals.onWinnerScreen = false;
            Globals.onMenu = true;
            Globals.restart();
        }
        return true;
    }

    public static void checkForCollisions() {
        int i = 0;
        while (i < Turn.faction.getBulletList().size()) {
            int j = 0;
            while (j < Globals.grid.getUsedCells().size) {
                if (Turn.faction.getBulletList().get(i).getXPos() >= ((float) Globals.grid.getUsedCells().get(j).getXPos()) - 0.3f && Turn.faction.getBulletList().get(i).getXPos() <= ((float) Globals.grid.getUsedCells().get(j).getXPos()) + 0.3f && ((Bullet) Turn.faction.getBulletList().get(i)).getYPos() >= ((float) ((OldCell) Globals.grid.getUsedCells().get(j)).getYPos()) - 0.3f && ((Bullet) Turn.faction.getBulletList().get(i)).getYPos() <= ((float) ((OldCell) Globals.grid.getUsedCells().get(j)).getYPos()) + 0.3f && Turn.faction != ((OldCell) Globals.grid.getUsedCells().get(j)).getUnit().getFaction() && Turn.faction.getColor() != ((OldCell) Globals.grid.getUsedCells().get(j)).getUnit().getFaction().getColor()) {
                    Turn.faction.getBulletList().get(i).onBulletCollision();
                    Globals.grid.getUsedCells().get(j).getUnit().onBulletCollision();
                    break;
                }
                j++;
            }
            i++;
        }
    }

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return keycode == 4;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }
}

package com.frontanilla.estratega.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.estratega.GameAssets;
import com.frontanilla.estratega.Player;

import static com.frontanilla.estratega.Constants.CAMERA_HEIGHT;
import static com.frontanilla.estratega.Constants.CAMERA_WIDTH;
import static com.frontanilla.estratega.Constants.CELL_SIZE;
import static com.frontanilla.estratega.Constants.COLUMNS;
import static com.frontanilla.estratega.Constants.ROWS;

public class GameStuff {

    private GameAssets assets;
    // Stuff
    private Cell[][] cells;
    private DelayedRemovalArray<Entity> entities;
    private DelayedRemovalArray<Player> players;
    private DelayedRemovalArray<AnimationWithTime> explosionAnimations;
    private Text moneyText;

    public void initializeStuff() {
        cells = new Cell[COLUMNS][];
        for (int column = 0; column < COLUMNS; column++) {
            cells[column] = new Cell[ROWS];
            for (int row = 0; row < ROWS; row++) {
                cells[column][row] = new Cell(assets.getCell());
                Sprite cell = cells[column][row];
                cell.setSize(CELL_SIZE, CELL_SIZE);
                cell.setX(column * cell.getWidth());
                cell.setY(row * cell.getHeight());
            }
        }

        entities = new DelayedRemovalArray<>();

        players = new DelayedRemovalArray<>();
        Player player1 = new Player(Color.RED);
        players.add(player1);
        Player player2 = new Player(Color.BLUE);
        players.add(player2);

        explosionAnimations = new DelayedRemovalArray<>();

        moneyText = new Text(assets.getFont(), "5$", CAMERA_WIDTH / 2f, CAMERA_HEIGHT - 10f);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public DelayedRemovalArray<Entity> getEntities() {
        return entities;
    }

    public DelayedRemovalArray<Player> getPlayers() {
        return players;
    }

    public DelayedRemovalArray<AnimationWithTime> getExplosionAnimations() {
        return explosionAnimations;
    }

    public Text getMoneyText() {
        return moneyText;
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}
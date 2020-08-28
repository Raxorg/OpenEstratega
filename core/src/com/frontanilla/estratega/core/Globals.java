package com.frontanilla.estratega.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.estratega.entities.Base;
import com.frontanilla.estratega.entities.Bullet;
import com.frontanilla.estratega.entities.OldTank;
import com.frontanilla.estratega.entities.Wall;

public class Globals {
    public static float columnWidth;
    public static DelayedRemovalArray<Faction> factions = new DelayedRemovalArray<>();
    public static Grid grid;
    public static float gridWidth;
    public static int numColumns;
    public static boolean onMatch;
    public static boolean onMenu;
    public static boolean onWinnerScreen;
    public static float rightSpaceWidth;
    public static int screenHeight;

    public static class ColorHolder {
        public static Color[] colors = new Color[10];
        public static Color[] colorsSelected = new Color[10];
        private static Color darkGreen;
        private static Color limeGreen;
        private static Color purple;

        private static void init() {
            darkGreen = new Color(0.0f, 0.7f, 0.0f, 1.0f);
            limeGreen = new Color(0.6f, 1.0f, 0.1f, 1.0f);
            purple = new Color(0.7f, 0.0f, 1.0f, 1.0f);
            colors[0] = Color.RED;
            colors[1] = Color.ORANGE;
            colors[2] = Color.YELLOW;
            colors[3] = limeGreen;
            colors[4] = darkGreen;
            colors[5] = Color.CYAN;
            colors[6] = Color.BLUE;
            colors[7] = purple;
            colors[8] = Color.PINK;
            colors[9] = Color.WHITE;
            colorsSelected[0] = Color.RED;
            colorsSelected[1] = Color.ORANGE;
            colorsSelected[2] = Color.YELLOW;
            colorsSelected[3] = limeGreen;
            colorsSelected[4] = darkGreen;
            colorsSelected[5] = Color.CYAN;
            colorsSelected[6] = Color.BLUE;
            colorsSelected[7] = purple;
            colorsSelected[8] = Color.PINK;
            colorsSelected[9] = Color.WHITE;
        }

        static void nextColor(int color) {
            if (colorsSelected[color] == Color.RED) {
                colorsSelected[color] = colors[1];
            } else if (colorsSelected[color] == Color.ORANGE) {
                colorsSelected[color] = colors[2];
            } else if (colorsSelected[color] == Color.YELLOW) {
                colorsSelected[color] = colors[3];
            } else if (colorsSelected[color] == limeGreen) {
                colorsSelected[color] = colors[4];
            } else if (colorsSelected[color] == darkGreen) {
                colorsSelected[color] = colors[5];
            } else if (colorsSelected[color] == Color.CYAN) {
                colorsSelected[color] = colors[6];
            } else if (colorsSelected[color] == Color.BLUE) {
                colorsSelected[color] = colors[7];
            } else if (colorsSelected[color] == purple) {
                colorsSelected[color] = colors[8];
            } else if (colorsSelected[color] == Color.PINK) {
                colorsSelected[color] = colors[9];
            } else if (colorsSelected[color] == Color.WHITE) {
                colorsSelected[color] = colors[0];
            }
        }
    }

    public static class FontHolder {
        public static BitmapFont scoreNumbers;
        public static BitmapFont teamsNumbers;

        private static void init() {
            float numbersXScale = (Globals.rightSpaceWidth * 0.6f) / 80.0f;
            float numbersYScale = (Globals.columnWidth * 0.6f) / 46.0f;
            scoreNumbers = new BitmapFont(Gdx.files.internal("Fonts/ThridFont.fnt"));
            scoreNumbers.getData().setScale(numbersXScale, numbersYScale);
            float teamsXScale = (((float) (Globals.screenHeight / 3)) * 0.6f) / 80.0f;
            float teamsYScale = (((float) (Globals.screenHeight / 3)) * 0.6f) / 46.0f;
            teamsNumbers = new BitmapFont(Gdx.files.internal("Fonts/ThridFont.fnt"));
            teamsNumbers.getData().setScale(teamsXScale, teamsYScale);
        }

        private static void dispose() {
            scoreNumbers.dispose();
            teamsNumbers.dispose();
        }
    }

    public static class SoundHolder {
        public static Sound buildWall;
        public static Sound buyTank;
        public static Sound destroy;
        public static Sound fireBullet;

        private static void init() {
            fireBullet = Gdx.audio.newSound(Gdx.files.internal("Sounds/firebullet.wav"));
            buildWall = Gdx.audio.newSound(Gdx.files.internal("Sounds/construccion.wav"));
            buyTank = Gdx.audio.newSound(Gdx.files.internal("Sounds/yessir.wav"));
            destroy = Gdx.audio.newSound(Gdx.files.internal("Sounds/explosion.wav"));
        }

        private static void dispose() {
            fireBullet.dispose();
            buildWall.dispose();
            buyTank.dispose();
            destroy.dispose();
        }
    }

    public static class TextureHolder {
        public static Texture backGround;
        public static Texture button;
        public static Texture buttonSelected;
        public static Texture colorFrame;
        public static Texture frame;
        public static Texture menu;
        public static Texture playButton;
        public static Texture scoreFrame;
        public static Texture sword;
        public static Texture teamsLabel;
        public static Texture transparent;
        public static Texture units;
        public static Texture winnerLabel;

        private static void init() {
            units = new Texture("Images/units.png");
            backGround = new Texture("Images/gridcolumn.png");
            transparent = new Texture("Images/transparent.png");
            button = new Texture("Images/button.png");
            buttonSelected = new Texture("Images/buttonselected.png");
            scoreFrame = new Texture("Images/scoreframe.png");
            menu = new Texture("Images/menu.png");
            frame = new Texture("Images/frame.png");
            playButton = new Texture("Images/playbutton.png");
            sword = new Texture("Images/sword.png");
            colorFrame = new Texture("Images/colorframe.png");
            teamsLabel = new Texture("Images/teamslabel.png");
            winnerLabel = new Texture("Images/winner.png");
            Base.setClassRegion(new TextureRegion(units, 0, 64, 32, 32));
            Bullet.setClassRegion(new TextureRegion(units, 32, 0, 32, 31));
            OldTank.setClassRegion(new TextureRegion(units, 0, 0, 32, 32));
            Wall.setClassRegion(new TextureRegion(units, 0, 32, 32, 32));
        }

        private static void dispose() {
            units.dispose();
            backGround.dispose();
            transparent.dispose();
            button.dispose();
            buttonSelected.dispose();
            scoreFrame.dispose();
            menu.dispose();
            frame.dispose();
            playButton.dispose();
            sword.dispose();
            colorFrame.dispose();
            teamsLabel.dispose();
            winnerLabel.dispose();
        }
    }

    static void init() {
        screenHeight = Gdx.graphics.getHeight();
        columnWidth = (float) (screenHeight / 8);
        numColumns = (int) ((((float) Gdx.graphics.getWidth()) / columnWidth) - 1.0f);
        gridWidth = columnWidth * ((float) numColumns);
        rightSpaceWidth = ((float) Gdx.graphics.getWidth()) - gridWidth;
        onMenu = true;
        grid = new Grid(numColumns, 8);
        TextureHolder.init();
        SoundHolder.init();
        FontHolder.init();
        ColorHolder.init();
    }

    static void dispose() {
        TextureHolder.dispose();
        SoundHolder.dispose();
        FontHolder.dispose();
    }

    public static void restart() {
        int i;
        int a = Turn.faction.getBulletList().size();
        for (i = 0; i < a; i++) {
            Turn.faction.getBulletList().remove(0);
        }
        int b = grid.getUsedCells().size;
        for (i = 0; i < b; i++) {
            grid.getUsedCells().get(0).removeUnit();
        }
        factions = new DelayedRemovalArray<>();
        Turn.firstRound = true;
        Turn.turnNumber = 0;
        InputManager.waitingForBullets = false;
    }
}

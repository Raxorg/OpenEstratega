package com.frontanilla.estratega.screens.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameAssets {

    private AssetManager assetManager;
    // Sprites
    private Sprite cell, button, buttonSelected, colorFrame, frame, menu, playButton, scoreFrame, sword, teamsLabel, transparent, units,
            winnerLabel, tank, bullet, pixel, base;
    // Animations
    private Animation<Sprite> explosionAnimation;
    // Audio
    private Sound shoutingSoldier, explosion;
    // Fonts
    private BitmapFont font;

    public GameAssets() {
        assetManager = new AssetManager();
    }

    public void queueAssetLoading() {
        // Sprites
        assetManager.load("Images/units.png", Texture.class);
        assetManager.load("Images/cell.png", Texture.class);
        assetManager.load("Images/transparent.png", Texture.class);
        assetManager.load("Images/button.png", Texture.class);
        assetManager.load("Images/buttonselected.png", Texture.class);
        assetManager.load("Images/scoreframe.png", Texture.class);
        assetManager.load("Images/menu.png", Texture.class);
        assetManager.load("Images/frame.png", Texture.class);
        assetManager.load("Images/playbutton.png", Texture.class);
        assetManager.load("Images/sword.png", Texture.class);
        assetManager.load("Images/colorframe.png", Texture.class);
        assetManager.load("Images/teamslabel.png", Texture.class);
        assetManager.load("Images/winner.png", Texture.class);
        assetManager.load("Images/button.png", Texture.class);
        // Animations
        assetManager.load("animations/explosionAnimation.png", Texture.class);
        // Audio
        assetManager.load("sounds/yessir.wav", Sound.class);
        assetManager.load("sounds/fireBullet.wav", Sound.class);
        // Fonts
        assetManager.load("fonts/ThridFont.fnt", BitmapFont.class);
    }

    public void finishLoadingAssets() {
        assetManager.finishLoading();
    }

    public void initializeAssets() {
        // Sprites
        units = new Sprite(assetManager.get("Images/units.png", Texture.class));
        tank = new Sprite(units, 0, 0, 32, 32);
        bullet = new Sprite(units, 45, 13, 6, 6);
        base = new Sprite(units, 0, 64, 32, 32);

        cell = new Sprite(assetManager.get("Images/cell.png", Texture.class));
        // Animations
        Texture explosionTex = assetManager.get("animations/explosionAnimation.png", Texture.class);
        Sprite[] animationSprites = new Sprite[16];
        animationSprites[0] = new Sprite(explosionTex, 0, 0, 64, 64);
        animationSprites[1] = new Sprite(explosionTex, 64, 0, 64, 64);
        animationSprites[2] = new Sprite(explosionTex, 64 * 2, 0, 64, 64);
        animationSprites[3] = new Sprite(explosionTex, 64 * 3, 0, 64, 64);

        animationSprites[4] = new Sprite(explosionTex, 0, 64, 64, 64);
        animationSprites[5] = new Sprite(explosionTex, 64, 64, 64, 64);
        animationSprites[6] = new Sprite(explosionTex, 64 * 2, 64, 64, 64);
        animationSprites[7] = new Sprite(explosionTex, 64 * 3, 64, 64, 64);

        animationSprites[8] = new Sprite(explosionTex, 0, 64 * 2, 64, 64);
        animationSprites[9] = new Sprite(explosionTex, 64, 64 * 2, 64, 64);
        animationSprites[10] = new Sprite(explosionTex, 64 * 2, 64 * 2, 64, 64);
        animationSprites[11] = new Sprite(explosionTex, 64 * 3, 64 * 2, 64, 64);

        animationSprites[12] = new Sprite(explosionTex, 0, 64 * 3, 64, 64);
        animationSprites[13] = new Sprite(explosionTex, 64, 64 * 3, 64, 64);
        animationSprites[14] = new Sprite(explosionTex, 64 * 2, 64 * 3, 64, 64);
        animationSprites[15] = new Sprite(explosionTex, 64 * 3, 64 * 3, 64, 64);
        explosionAnimation = new Animation<>(0.1f, animationSprites);

        pixel = new Sprite(assetManager.get("Images/button.png", Texture.class));
        // Audio
        shoutingSoldier = assetManager.get("sounds/yessir.wav", Sound.class);
        explosion = assetManager.get("sounds/fireBullet.wav", Sound.class);
        // Fonts
        font = assetManager.get("fonts/ThridFont.fnt", BitmapFont.class);
    }

    // Sprites
    public Sprite getCell() {
        return cell;
    }

    public Sprite getTank() {
        return tank;
    }

    public Sprite getBullet() {
        return bullet;
    }

    public Sprite getPixel() {
        return pixel;
    }

    public Sprite getBase() {
        return base;
    }

    // Animations
    public Animation<Sprite> getExplosionAnimation() {
        return explosionAnimation;
    }

    // Audio
    public Sound getShoutingSoldier() {
        return shoutingSoldier;
    }

    public Sound getExplosion() {
        return explosion;
    }

    // Fonts
    public BitmapFont getFont() {
        return font;
    }
}
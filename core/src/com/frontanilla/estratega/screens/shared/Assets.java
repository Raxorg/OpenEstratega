package com.frontanilla.estratega.screens.shared;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import static com.frontanilla.estratega.screens.shared.AssetPaths.IMAGE_PATHS;

public class Assets {

    private final AssetManager assetManager;
    // Animations

    // Audio

    // Fonts

    // Sprites


    public Assets() {
        assetManager = new AssetManager();
    }

    public void queueAssetLoading() {
        for (int i = 0; i < IMAGE_PATHS.length; i++) {
            assetManager.load(IMAGE_PATHS[i], Texture.class);
        }
    }

    public boolean loadAssets() {
        return assetManager.update();
    }

    public void initializeAssets() {

    }
}
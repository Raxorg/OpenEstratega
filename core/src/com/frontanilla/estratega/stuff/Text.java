package com.frontanilla.estratega.stuff;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Text {

    private BitmapFont font;
    private String text;
    private float x, y;

    public Text(BitmapFont font, String text, float x, float y) {
        this.font = font;
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public void draw(SpriteBatch spriteBatch) {
        font.draw(spriteBatch, text, x, y);
    }

    public void setText(String text) {
        this.text = text;
    }
}
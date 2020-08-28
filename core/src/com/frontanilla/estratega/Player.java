package com.frontanilla.estratega;

import com.badlogic.gdx.graphics.Color;

public class Player {

    private Color color;
    private int money;

    public Player(Color color) {
        this.color = color;
        money = 10;
    }

    public Color getColor() {
        return color;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
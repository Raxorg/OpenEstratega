package com.frontanilla.estratega.logic;

import com.frontanilla.estratega.Player;
import com.frontanilla.estratega.stuff.GameStuff;

public class TurnHandler {

    private GameStuff stuff;
    // Logic
    private int turn;
    private Player currentPlayer;

    public void init() {
        currentPlayer = stuff.getPlayers().get(0);
    }

    public void passTurn() {
        turn++;
        if (stuff.getPlayers().size == turn) {
            turn = 0;
        }
        currentPlayer = stuff.getPlayers().get(turn);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
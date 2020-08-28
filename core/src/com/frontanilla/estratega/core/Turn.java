package com.frontanilla.estratega.core;

public class Turn {
    public static Faction faction = Globals.factions.get(0);
    public static boolean firstRound = true;
    public static int turnNumber = 0;

    public static void passTurn() {
        if (turnNumber < Globals.factions.size - 1) {
            turnNumber++;
        } else {
            firstRound = false;
            turnNumber = 0;
            for (int i = 0; i < Globals.factions.size; i++) {
                Globals.factions.get(i).setMoney(Globals.factions.get(i).getMoney() + 4);
                if (Globals.factions.get(i).getMoney() >= 100) {
                    Globals.factions.get(i).setMoney(99);
                }
            }
        }
        faction = Globals.factions.get(turnNumber);
    }
}

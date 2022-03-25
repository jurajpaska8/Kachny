package models.gameCards;

import models.abstractions.GameCard;

public class DuckCard extends GameCard
{
    private static final int DUCK_CARD_COUNT_EACH_PLAYER = 5;
    private final String player; // TODO from class

    public DuckCard(String player)
    {
        this.player = player;
    }

    @Override
    public String toString()
    {
        return "Duck: " + player;
    }

    private boolean moveAfterAbsorbingShoot() // TODO to ifc
    {
        return true;
    }

    @Override
    public boolean absorbShoot()
    {
        System.out.println("You hit duck of player: '" + player + "'.");
        return moveAfterAbsorbingShoot();
    }
}

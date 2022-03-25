package models.gameCards;

import exceptions.EmptyHealthBarException;
import models.Player;
import models.abstractions.GameCard;

public class DuckCard extends GameCard
{
    private static final int DUCK_CARD_COUNT_EACH_PLAYER = 5;
    private final Player player; // TODO from class
    private int health = 5; // TODO from class

    public DuckCard(Player player)
    {
        this.player = player;
    }

    @Override
    public String toString()
    {
        return "Duck: " + player.getName();
    }

    private boolean moveAfterAbsorbingShoot() // TODO to ifc
    {
        return true;
    }

    @Override
    public boolean absorbShoot()
    {
        try
        {
            System.out.println("You hit duck of player: '" + player.getName() + "'.");
            player.decreaseHealth();
        }
        catch(EmptyHealthBarException e)
        {
            System.out.println("Player should be dead and not continue in game. Message: " + e.getMessage());
        }
        return moveAfterAbsorbingShoot();
    }
}

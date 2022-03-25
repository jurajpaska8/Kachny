package cards.gameCards;

import exceptions.EmptyHealthBarException;
import models.Player;
import models.abstractions.GameCard;

public class DuckCard extends GameCard
{
    private final Player player;

    public DuckCard(Player player)
    {
        this.player = player;
    }

    @Override
    public String toString()
    {
        return "Duck: " + player.getName();
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

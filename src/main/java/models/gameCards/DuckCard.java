package models.gameCards;

import models.Player;
import models.abstractions.GameCard;

public class DuckCard extends GameCard
{
    private static final int DUCK_CARD_COUNT_EACH_PLAYER = 5;
    private final Player player; // TODO from class

    public DuckCard(Player player)
    {
        this.player = player;
    }
}

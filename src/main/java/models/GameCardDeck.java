package models;

import exceptions.EmptyDeckException;
import exceptions.IllegalCountOfPlayersException;
import models.abstractions.GameCard;
import models.abstractions.ICardDeck;
import models.gameCards.DuckCard;
import models.gameCards.WaterCard;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GameCardDeck implements ICardDeck
{
    private final static int MIN_PLAYER_COUNT = 2;
    private final static int MAX_PLAYER_COUNT = 6;
    private final int playerCount;
    private final List<GameCard> gameCardDeck;

    public GameCardDeck(int playerCount, int ducksCardPerPlayer, int waterCard) throws IllegalCountOfPlayersException
    {
        if(!isPlayerCountInRange(playerCount))
        {
            throw new IllegalArgumentException("Illegal count of players ( " + playerCount + " ). Allowed count of players: [" + MIN_PLAYER_COUNT + ", " + MAX_PLAYER_COUNT + "]");
        }
        this.playerCount = playerCount;
        this.gameCardDeck = initGameCards(playerCount, ducksCardPerPlayer, waterCard);
        this.shuffle();
    }

    public List<GameCard> getGameCardDeck()
    {
        return gameCardDeck;
    }

    private boolean isPlayerCountInRange(int playerCount)
    {
        return playerCount >= MIN_PLAYER_COUNT && playerCount <= MAX_PLAYER_COUNT;
    }

    private List<GameCard> initGameCards(int playerCount, int ducksCardPerPlayer, int waterCard)
    {
        List<GameCard> gameCardList = new LinkedList<>();
        for(int i = 0; i < playerCount; i++)
        {
            var player = "player" + i;
            for(int j = 0; j < ducksCardPerPlayer; j++)
            {
                gameCardList.add(new DuckCard(player));
            }
        }

        for(int i = 0; i < waterCard; i++)
        {
            gameCardList.add(new WaterCard());
        }
        return gameCardList;
    }

    @Override
    public GameCard popCard() throws EmptyDeckException
    {
        if(gameCardDeck.isEmpty())
        {
            throw new EmptyDeckException("Action Card Deck is empty");
        }
        var cardToPop = gameCardDeck.get(0);
        gameCardDeck.remove(0);
        return cardToPop;
    }

    @Override
    public void shuffle()
    {
        Collections.shuffle(gameCardDeck);
    }
}

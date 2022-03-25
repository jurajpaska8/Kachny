package decks;

import exceptions.EmptyDeckException;
import exceptions.IllegalCountOfPlayersException;
import models.Player;
import models.abstractions.GameCard;
import models.abstractions.interfaces.ICardDeck;
import cards.gameCards.DuckCard;
import cards.gameCards.WaterCard;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GameCardDeck implements ICardDeck
{
    public final static int MIN_PLAYER_COUNT = 2;
    public final static int MAX_PLAYER_COUNT = 6;
    private final List<GameCard> gameCardDeck;

    public GameCardDeck(List<Player> playerList, int ducksCardPerPlayer, int waterCard) throws IllegalCountOfPlayersException
    {
        if(!isPlayerCountInRange(playerList.size()))
        {
            throw new IllegalArgumentException("Illegal count of players ( " + playerList.size() + " ). Allowed count of players: [" + MIN_PLAYER_COUNT + ", " + MAX_PLAYER_COUNT + "]");
        }
        this.gameCardDeck = initGameCards(playerList, ducksCardPerPlayer, waterCard);
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

    private List<GameCard> initGameCards(List<Player> playerList, int ducksCardPerPlayer, int waterCard)
    {
        List<GameCard> gameCardList = new LinkedList<>();
        for(Player player : playerList)
        {
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

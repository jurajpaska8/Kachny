import exceptions.IllegalCountOfPlayersException;
import models.ActionCardDeck;
import models.GameCardDeck;
import models.Player;
import models.Pond;

import java.util.LinkedList;

public class Main
{
    public static final int DUCKS_CARDS_PER_PLAYER = 5;
    public static final int WATER_CARDS = 5;

    public static void main(String[] args)
    {
        try
        {
            System.out.println("Toto je kachna");
            // game cards
            var playersCount = 2;
            var ducksPerPlayer = 5;
            var waterCount = 5;

            // action cards - move
            var duckMarchCardCount = 6;
            var turboCardCount = 1;
            var rosamboCardCount = 2;
            var duckDanceCardCount = 1;
            // action cards - shooting
            var aimCardCount = 10;
            var shootCardCount = 12;
            var wildBillCardCount = 2;

            // decks
            var gameCards = new GameCardDeck(playersCount, ducksPerPlayer, waterCount); //TODO inject players
            var actionCards = new ActionCardDeck(duckMarchCardCount, turboCardCount, rosamboCardCount, duckDanceCardCount,
                    aimCardCount, shootCardCount, wildBillCardCount);

            // pond
            Pond pond = new Pond();
            pond.initPond(gameCards);

            var players = new LinkedList<Player>();
            for(int i = 0; i < playersCount; i++)
            {
                var player = new Player("player " + i);
                player.takeThreeCards(actionCards);
                players.add(player);
            }
            pond.printPond();

            var rounds = 5;
            for(int i = 0; i < rounds; i++)
            {
                for(var player : players)
                {
                    player.playCard(actionCards);
                    player.takeCardFromDeck(actionCards);
                }
            }
            
            System.out.println("");
        }
        catch(IllegalCountOfPlayersException e)
        {
            e.printStackTrace();
        }
    }
}

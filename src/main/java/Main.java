import exceptions.IllegalCountOfPlayersException;
import models.ActionCardDeck;
import models.GameCardDeck;
import models.Player;
import models.Pond;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private static void printPlayers(List<Player> players)
    {
        for(var player:players)
        {
            System.out.println(player.getName() + ", health: " + player.getHealth());
        }
    }

    private static void printActionDeck(ActionCardDeck actionCardDecks)
    {
        System.out.println("Size of action card deck: " + actionCardDecks.getActionCardDeck().size());
        for(var card : actionCardDecks.getActionCardDeck())
        {
            System.out.println(card.toString());
        }
    }

    private static void printGameCard(GameCardDeck gameCardDeck)
    {
        System.out.println("Size of game card deck: " + gameCardDeck.getGameCardDeck().size());
        for(var card : gameCardDeck.getGameCardDeck())
        {
            System.out.println(card.toString());
        }
    }

    public static void main(String[] args)
    {
        try
        {
            System.out.println("Toto je kachna");
            var scanner = new Scanner(new InputStreamReader(System.in));
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

            // action deck
            var actionCards = new ActionCardDeck(duckMarchCardCount, turboCardCount, rosamboCardCount, duckDanceCardCount,
                    aimCardCount, shootCardCount, wildBillCardCount);

            // players
            var players = new LinkedList<Player>();
            for(int i = 0; i < playersCount; i++)
            {
                var player = new Player("player " + i, ducksPerPlayer);
                player.takeThreeCards(actionCards);
                players.add(player);
            }

            // game deck
            var gameCards = new GameCardDeck(players, ducksPerPlayer, waterCount); //TODO inject players


            // pond
            Pond pond = new Pond();
            pond.initPond(gameCards);


            var rounds = 5;
            for(int i = 0; i < rounds; i++)
            {
                printPlayers(players);
                printActionDeck(actionCards);
                printGameCard(gameCards);
                for(var player : players)
                {
                    pond.printPond();
                    player.playCard(actionCards, pond, gameCards, scanner);
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

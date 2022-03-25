package models;

import decks.ActionCardDeck;
import decks.GameCardDeck;
import exceptions.IllegalCountOfPlayersException;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game
{
    List<Player> players;
    ActionCardDeck actionCardDeck;
    GameCardDeck gameCardDeck;

    private void printPlayers()
    {
        for(var player:players)
        {
            System.out.println(player.getName() + ", health: " + player.getHealth());
        }
    }

    private void printActionDeck()
    {
        System.out.println("Size of action card deck: " + actionCardDeck.getActionCardDeck().size());
        for(var card : actionCardDeck.getActionCardDeck())
        {
            System.out.println(card.toString());
        }
    }

    private void printGameCard()
    {
        System.out.println("Size of game card deck: " + gameCardDeck.getGameCardDeck().size());
        for(var card : gameCardDeck.getGameCardDeck())
        {
            System.out.println(card.toString());
        }
    }

    private boolean isLastAlive(Player player)
    {
        var alivePlayers = players.stream().filter(p -> !p.isDead()).collect(Collectors.toList());
        return alivePlayers.size() == 1 && alivePlayers.get(0).getName().equals(player.getName());
    }

    public void playGame()
    {
        try
        {
            System.out.println("Toto je kachna");
            var scanner = new Scanner(new InputStreamReader(System.in));
            System.out.println("Choose number of players in range [0, " + (GameCardDeck.MAX_PLAYER_COUNT - 1) + "]");
            var playersCount = 2; // TODO configurable

            // game cards
            var ducksPerPlayer = 5;
            var waterCount = 5;
            var pondSize = 6;

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
            actionCardDeck = new ActionCardDeck(duckMarchCardCount, turboCardCount, rosamboCardCount, duckDanceCardCount,
                    aimCardCount, shootCardCount, wildBillCardCount);

            // players
            players = new LinkedList<>();
            for(int i = 0; i < playersCount; i++)
            {
                var player = new Player("player " + i, ducksPerPlayer);
                player.takeThreeCards(actionCardDeck);
                players.add(player);
            }

            // game deck
            gameCardDeck = new GameCardDeck(players, ducksPerPlayer, waterCount);

            // pond
            Pond pond = new Pond(pondSize);
            pond.initPond(gameCardDeck);


            var isOnlyOnePlayerAlive = false;
            while(!isOnlyOnePlayerAlive)
            {
                this.printPlayers();
                // printActionDeck(actionCards); // For debug
                // printGameCard(gameCards);  // For debug
                for(var player : players)
                {
                    if(player.isDead())
                    {
                        continue;
                    }
                    if(isLastAlive(player))
                    {
                        System.out.println("Player: '" + player.getName() + "' WON THE GAME!!!");
                        isOnlyOnePlayerAlive = true;
                        break;
                    }
                    pond.printPond();
                    player.playCard(actionCardDeck, pond, gameCardDeck, scanner);
                    player.takeCardFromDeck(actionCardDeck);
                }
            }
        }
        catch(IllegalCountOfPlayersException e)
        {
            System.out.println("Not allowed count of players. Message: " + e.getMessage());
            playGame();
        }
    }
}

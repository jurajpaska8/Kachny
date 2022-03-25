package models;

import exceptions.EmptyDeckException;
import exceptions.NotPlayableCardException;
import jdk.jshell.spi.ExecutionControl;
import models.abstractions.ActionCard;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Player
{
    private final String name;
    private int health;
    private final List<ActionCard> playerActionCards;

    public Player(String name, int health)
    {
        this.name = name;
        this.health = health;
        playerActionCards = new LinkedList<>();
    }

    public String getName()
    {
        return name;
    }

    public void takeCardFromDeck(ActionCardDeck actionCardDeck)
    {
        try
        {
            playerActionCards.add(actionCardDeck.popCard());
        }
        catch(EmptyDeckException e)
        {
            System.err.println("Player: '" + name + "' can not grab card.");
        }
    }

    public void takeThreeCards(ActionCardDeck actionCardDeck)
    {
        try
        {
            playerActionCards.add(actionCardDeck.popCard());
            playerActionCards.add(actionCardDeck.popCard());
            playerActionCards.add(actionCardDeck.popCard());
        }
        catch(EmptyDeckException e)
        {
            System.err.println("Player: '" + name + "' can not grab card.");
        }
    }

    void printPlayerActionCards()
    {
        System.out.println("* Player: '" + name + "' is choosing card:");
        for(var i = 0; i < playerActionCards.size(); i++)
        {
            System.out.println("** idx: '" + i + "' " + playerActionCards.get(i).getCardDescription());
        }
    }

    public void playCard(ActionCardDeck actionCardDeck, Pond pond, GameCardDeck gameCardDeck, Scanner scanner)
    {
        try
        {
            printPlayerActionCards();
            var idx = scanner.nextInt();
            // TODO edge cases
            var card = playerActionCards.get(idx);
            card.doAction(pond, gameCardDeck, scanner);
            playerActionCards.remove(idx);
            actionCardDeck.getActionCardDeck().add(card);
        }
        catch(NotPlayableCardException e)
        {
            System.err.println("Card is not playable.");
            playCard(actionCardDeck, pond, gameCardDeck, scanner);
        }
    }

    public int getHealth()
    {
        return health;
    }

    public void decreaseHealth()
    {
        // TODO exception ?
        this.health--;
    }

}

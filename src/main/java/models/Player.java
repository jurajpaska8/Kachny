package models;

import exceptions.EmptyDeckException;
import jdk.jshell.spi.ExecutionControl;
import models.abstractions.ActionCard;

import java.util.LinkedList;
import java.util.List;

public class Player
{
    private String name;
    private int life = 5;
    private final List<ActionCard> playerActionCards;

    public Player(String name)
    {
        this.name = name;
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

    public void playCard(ActionCardDeck actionCardDeck)
    {
        // TODO implement pick
        var card = playerActionCards.get(0);
        playerActionCards.remove(0);
        actionCardDeck.getActionCardDeck().add(card);
    }
}

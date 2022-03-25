package models;

import exceptions.EmptyDeckException;
import exceptions.EmptyHealthBarException;
import exceptions.NotPlayableCardException;
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

    private boolean isAtLeastOneCardPlayable(Pond pond)
    {
        return playerActionCards
                .stream()
                .anyMatch(c -> c.isPlayable(pond));
    }

    public void playCard(ActionCardDeck actionCardDeck, Pond pond, GameCardDeck gameCardDeck, Scanner scanner)
    {
        int idx = -1;
        try
        {
            printPlayerActionCards();
            if(!isAtLeastOneCardPlayable(pond))
            {
                System.out.println("You can not play any card. Choose one card to throw.");
                idx = scanner.nextInt();
                actionCardDeck.getActionCardDeck().add(playerActionCards.get(idx));
                playerActionCards.remove(idx);
            }
            else
            {
                idx = scanner.nextInt();
                var card = playerActionCards.get(idx);
                card.doAction(pond, gameCardDeck, actionCardDeck, scanner);
                playerActionCards.remove(idx);
            }
        }
        catch(NotPlayableCardException e)
        {
            System.err.println("Card is not playable.");
            playCard(actionCardDeck, pond, gameCardDeck, scanner);
        }
        catch(IndexOutOfBoundsException e)
        {
            System.err.println("Card with index: '" + idx + "' is out of range [0 ," + (playerActionCards.size() - 1) + "].");
            playCard(actionCardDeck, pond, gameCardDeck, scanner);
        }
    }

    public int getHealth()
    {
        return health;
    }

    public boolean isDead()
    {
        return health <= 0;
    }

    public void decreaseHealth() throws EmptyHealthBarException
    {
        if(health <= 0)
        {
            throw new EmptyHealthBarException("Fatal error: Health bar is already empty. Something weird is going on in application");
        }
        this.health--;
    }

}

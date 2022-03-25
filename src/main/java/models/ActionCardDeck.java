package models;

import exceptions.EmptyDeckException;
import models.abstractions.ActionCard;
import models.abstractions.ICardDeck;
import models.actionCards.movementCards.DuckDanceCard;
import models.actionCards.movementCards.DuckMarchCard;
import models.actionCards.movementCards.RosamboCard;
import models.actionCards.movementCards.TurboDuckCard;
import models.actionCards.shootingCards.AimCard;
import models.actionCards.shootingCards.ShootCard;
import models.actionCards.shootingCards.WildBillCard;

import java.util.*;
import java.util.stream.Collectors;

public class ActionCardDeck implements ICardDeck
{
    private List<ActionCard> actionCardDeck;

    public ActionCardDeck(int duckMarchCardCount, int turboDuckCount, int rosamboCardCount, int duckDanceCardCount,
                          int aimCardCount, int shootCardCount, int wildBillCardCount)
    {
        actionCardDeck = initGameCards(duckMarchCardCount, turboDuckCount, rosamboCardCount, duckDanceCardCount,
        aimCardCount, shootCardCount, wildBillCardCount);
        shuffle();
    }

    private List<ActionCard> initGameCards(int duckMarchCardCount, int turboDuckCount, int rosamboCardCount, int duckDanceCardCount,
                                           int aimCardCount, int shootCardCount, int wildBillCardCount)
    {
        actionCardDeck = new LinkedList<>();
        for(var i = 0; i < turboDuckCount; i++)
        {
            actionCardDeck.add(new DuckMarchCard());
        }
        for(var i = 0; i < duckMarchCardCount; i++)
        {
            actionCardDeck.add(new TurboDuckCard());
        }
        for(var i = 0; i < rosamboCardCount; i++)
        {
            actionCardDeck.add(new RosamboCard());
        }
        for(var i = 0; i < duckDanceCardCount; i++)
        {
            actionCardDeck.add(new DuckDanceCard());
        }
        for(var i = 0; i < aimCardCount; i++)
        {
            actionCardDeck.add(new AimCard());
        }
        for(var i = 0; i < shootCardCount; i++)
        {
            actionCardDeck.add(new ShootCard());
        }
        for(var i = 0; i < wildBillCardCount; i++)
        {
            actionCardDeck.add(new WildBillCard());
        }

        return actionCardDeck;
    }

    public List<ActionCard> getActionCardDeck()
    {
        return actionCardDeck;
    }

    public ActionCard popCard() throws EmptyDeckException
    {
        if(actionCardDeck.isEmpty())
        {
            throw new EmptyDeckException("Action Card Deck is empty");
        }
        var cardToPop = actionCardDeck.get(0);
        actionCardDeck.remove(0);
        return cardToPop;
    }

    @Override
    public void shuffle()
    {
        Collections.shuffle(actionCardDeck);
    }
}

package models.abstractions;

import exceptions.NotPlayableCardException;
import models.ActionCardDeck;
import models.GameCardDeck;
import models.Pond;

import java.util.Scanner;

public abstract class ActionCard extends Card
{
    // description belongs to class, therefore is static
    public static final String CARD_DESC = "This is default action card description";

    public boolean isPlayable(Pond pond)
    {
        return true;
    }

    public abstract void doAction(Pond pond, GameCardDeck gameCardDeck, ActionCardDeck actionCardDeck, Scanner scanner) throws NotPlayableCardException;
}

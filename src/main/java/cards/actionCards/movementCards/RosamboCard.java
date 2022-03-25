package cards.actionCards.movementCards;

import exceptions.NotPlayableCardException;
import decks.ActionCardDeck;
import decks.GameCardDeck;
import models.Pond;
import models.abstractions.MovementActionCard;

import java.util.Scanner;

public class RosamboCard extends MovementActionCard
{
    public static final String CARD_DESC = "Náhodne premiešajte pozície všetkých kariet v rybníku. Zameriavače ostávajú na svojich miestach (spravte shuffle na kartách v rybníku).";

    @Override
    public void doAction(Pond pond, GameCardDeck gameCardDeck, ActionCardDeck actionCardDeck, Scanner scanner) throws NotPlayableCardException
    {
        actionCardDeck.getActionCardDeck().add(this);
    }
}

package cards.actionCards.movementCards;

import exceptions.NotPlayableCardException;
import decks.ActionCardDeck;
import decks.GameCardDeck;
import models.Pond;
import models.abstractions.MovementActionCard;

import java.util.Scanner;

public class DuckDanceCard extends MovementActionCard
{
    public static final String CARD_DESC = "Zoberte karty z rybníka a zamiešajte ich s balíčkom s kačicami. Potom vyložte nových 6 kariet do rybníka";

    @Override
    public void doAction(Pond pond, GameCardDeck gameCardDeck, ActionCardDeck actionCardDeck, Scanner scanner) throws NotPlayableCardException
    {
        actionCardDeck.getActionCardDeck().add(this);
    }
}

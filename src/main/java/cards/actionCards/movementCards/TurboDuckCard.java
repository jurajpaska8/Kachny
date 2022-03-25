package cards.actionCards.movementCards;

import exceptions.NotPlayableCardException;
import decks.ActionCardDeck;
import decks.GameCardDeck;
import models.Pond;
import models.abstractions.MovementActionCard;

import java.util.Scanner;

public class TurboDuckCard extends MovementActionCard
{
    public static final String CARD_DESC = "Posuňte ľubovoľnú kačku na políčko najviac v predu rybníka. Kačky, ktoré predbehla, posuňte o jedno miesto dozadu.";

    @Override
    public void doAction(Pond pond, GameCardDeck gameCardDeck, ActionCardDeck actionCardDeck, Scanner scanner) throws NotPlayableCardException
    {
        actionCardDeck.getActionCardDeck().add(this);
    }
}

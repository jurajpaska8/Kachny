package models.actionCards.movementCards;

import exceptions.NotPlayableCardException;
import models.GameCardDeck;
import models.Pond;
import models.abstractions.MovementActionCard;

import java.util.Scanner;

public class DuckMarchCard extends MovementActionCard
{
    public static final String CARD_DESC = "Posuňte všetky karty v rade o jedno políčko dopredu. Prvú kartu vráťte späť na koniec balíčka s kačicami, a voľné pole na konci rybníka doplňte kartou z vrchu balíčka s kačicami.";

    @Override
    public void doAction(Pond pond, GameCardDeck gameCardDeck, Scanner scanner) throws NotPlayableCardException
    {

    }
}

package models.actionCards.movementCards;

import models.Pond;
import models.abstractions.MovementActionCard;

public class DuckMarchCard extends MovementActionCard
{
    public static final String CARD_DESC = "Posuňte všetky karty v rade o jedno políčko dopredu. Prvú kartu vráťte späť na koniec balíčka s kačicami, a voľné pole na konci rybníka doplňte kartou z vrchu balíčka s kačicami.";

    @Override
    public void applyCard(Pond pond, int fieldIdx)
    {
        pond.getFieldsInPond();
    }
}

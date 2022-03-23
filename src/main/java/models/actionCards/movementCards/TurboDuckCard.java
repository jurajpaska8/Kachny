package models.actionCards.movementCards;

import models.Pond;
import models.abstractions.MovementActionCard;

public class TurboDuckCard extends MovementActionCard
{
    public static final String CARD_DESC = "Posuňte ľubovoľnú kačku na políčko najviac v predu rybníka. Kačky, ktoré predbehla, posuňte o jedno miesto dozadu.";

    @Override
    public void applyCard(Pond pond, int fieldIdx)
    {

    }
}

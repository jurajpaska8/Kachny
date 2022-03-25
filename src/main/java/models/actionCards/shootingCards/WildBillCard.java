package models.actionCards.shootingCards;

import models.Pond;
import models.abstractions.ShootingActionCard;

import java.util.Scanner;

public class WildBillCard extends ShootingActionCard
{
    public static final String CARD_DESC = "2 Karty. Funguje ako kombinácia kariet Zamieriť a Vystreliť. Odstráňte z rybníka ľubovoľnú kačku. Pokiaľ nad daným políčkom bol zameriavač, vráťte ho do kôpky. Kačice v rybníku sa musia posunúť aby zaplnili dieru, tak ako v prípade karty vystreliť.";

    @Override
    public void doAction(Pond pond, Scanner scanner)
    {

    }
}

package models.actionCards.shootingCards;

import models.ActionCardDeck;
import models.GameCardDeck;
import models.Pond;
import models.abstractions.ShootingActionCard;

import java.util.Scanner;

public class WildBillCard extends ShootingActionCard
{
    public static final String CARD_DESC = "2 Karty. Funguje ako kombinácia kariet Zamieriť a Vystreliť. Odstráňte z rybníka ľubovoľnú kačku. Pokiaľ nad daným políčkom bol zameriavač, vráťte ho do kôpky. Kačice v rybníku sa musia posunúť aby zaplnili dieru, tak ako v prípade karty vystreliť.";

    @Override
    public void doAction(Pond pond, GameCardDeck gameCardDeck, ActionCardDeck actionCardDeck, Scanner scanner)
    {
        {
            System.out.println("Choose field index to use WildBill. Indices: [0," + (pond.getPondSize() - 1) + "]:");
            var idx = scanner.nextInt();
            try
            {
                if(pond.isAimed(idx))
                {
                    actionCardDeck.getActionCardDeck().add(new AimCard());
                }
                pond.useWildBill(idx, gameCardDeck);
                actionCardDeck.getActionCardDeck().add(this);
            }
            catch(IndexOutOfBoundsException e)
            {
                System.err.println("Try to shoot on other field. Message: " + e.getMessage());
                doAction(pond, gameCardDeck, actionCardDeck, scanner);
            }
        }
    }
}

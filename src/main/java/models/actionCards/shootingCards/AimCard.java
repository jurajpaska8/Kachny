package models.actionCards.shootingCards;

import exceptions.NotPlayableCardException;
import exceptions.FieldAlreadyAimedException;
import models.GameCardDeck;
import models.Pond;
import models.abstractions.ShootingActionCard;

import java.util.Scanner;

public class AimCard extends ShootingActionCard
{
    public static final String CARD_DESC = "10 Kariet. Zahraním karty zamieriť si zvolíme, nad ktoré políčko v rybníku zamierime. Túto kartu vieme zahrať iba na políčko, nad ktorým ešte zameriavač nie je. Zamierime iba nad toto dané mieto v rybníku, nie na konkrétnu kačku. To znamená, že ak sa kačka z tohto miesta pohla, zameriavač stále ostáva na mieste, a zamierené bude na inú kačku alebo na kartu vody. Môžeme zamieriť aj na miesto, kde sa nachádza v rybníku voda.";

    @Override
    public void doAction(Pond pond, GameCardDeck gameCardDeck, Scanner scanner) throws NotPlayableCardException
    {
        if(pond.isAllFieldsAimed())
        {
            throw new NotPlayableCardException("You can not choose aim card. All fields are aimed");
        }
        System.out.println("Choose field index to aim. Indices: [0," + (Pond.POND_SIZE - 1) + "]:");
        var idx = scanner.nextInt();
        try
        {
            pond.aimOnField(idx);
        }
        catch(FieldAlreadyAimedException | IndexOutOfBoundsException e)
        {
            System.err.println("Try to aim on other field. Message: " + e.getMessage());
            doAction(pond, gameCardDeck, scanner);
        }
    }
}

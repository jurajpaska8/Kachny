package models.actionCards.shootingCards;

import exceptions.FieldAlreadyAimedException;
import exceptions.FieldNotAimedException;
import exceptions.NotPlayableCardException;
import models.Pond;
import models.abstractions.ShootingActionCard;

import java.util.Scanner;

public class ShootCard extends ShootingActionCard
{
    public static final String CARD_DESC = "12 Kariet. Zahraním karty vystreliť vieme streliť na zamierené políčko. Nie je podstatné , ktorý hráč zamieril na dané políčko. Hociktorú kačku, ktorá sa nachádza na zamierenom políčku môže zasteliť hociktorý hráč. Zastrelená kačka je odstránená z hry. Všetky karty, ktoré sa nachádzajú za touto kačkou posunte o jedno pole dopredu, a na koniec doplne kartu z balíčka. Po vystrelení odstránte zameriavač. Kartu vystreliť ide zahrať aj keď je zamierené políčko s vodou. V tom prípade však karta vody ostáva na svojom mieste a odstránime iba zameriavač.";

    @Override
    public void doAction(Pond pond, Scanner scanner) throws NotPlayableCardException
    {
        if(pond.isAllFieldsNotAimed())
        {
            throw new NotPlayableCardException("No field is aimed. You can not use shoot card");
        }
        System.out.println("Choose field index to shoot. Indices: [0," + (Pond.POND_SIZE - 1) + "]:");
        var idx = scanner.nextInt();
        try
        {
            pond.shootOnField(idx);
        }
        catch(FieldNotAimedException | IndexOutOfBoundsException e)
        {
            System.err.println("Try to shoot on other field. Message: " + e.getMessage());
            doAction(pond, scanner);
        }
    }
}

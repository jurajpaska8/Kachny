package cards.actionCards.shootingCards;

import exceptions.FieldNotAimedException;
import exceptions.NotPlayableCardException;
import decks.ActionCardDeck;
import decks.GameCardDeck;
import models.Pond;
import models.abstractions.ShootingActionCard;

import java.util.Scanner;

public class ShootCard extends ShootingActionCard
{
    public static final String CARD_DESC = "12 Kariet. Zahraním karty vystreliť vieme streliť na zamierené políčko. Nie je podstatné , ktorý hráč zamieril na dané políčko. Hociktorú kačku, ktorá sa nachádza na zamierenom políčku môže zasteliť hociktorý hráč. Zastrelená kačka je odstránená z hry. Všetky karty, ktoré sa nachádzajú za touto kačkou posunte o jedno pole dopredu, a na koniec doplne kartu z balíčka. Po vystrelení odstránte zameriavač. Kartu vystreliť ide zahrať aj keď je zamierené políčko s vodou. V tom prípade však karta vody ostáva na svojom mieste a odstránime iba zameriavač.";

    @Override
    public boolean isPlayable(Pond pond)
    {
        return !pond.isAllFieldsNotAimed();
    }

    @Override
    public void doAction(Pond pond, GameCardDeck gameCardDeck, ActionCardDeck actionCardDeck, Scanner scanner) throws NotPlayableCardException
    {
        if(!isPlayable(pond))
        {
            throw new NotPlayableCardException("No field is aimed. You can not use shoot card");
        }
        System.out.println("Choose field index to shoot. Indices: [0," + (pond.getPondSize() - 1) + "]:");
        var idx = scanner.nextInt();
        try
        {
            pond.shootOnField(idx, gameCardDeck);
            actionCardDeck.getActionCardDeck().add(this);
            actionCardDeck.getActionCardDeck().add(new AimCard());
        }
        catch(FieldNotAimedException | IndexOutOfBoundsException e)
        {
            System.err.println("Try to shoot on other field. Message: " + e.getMessage());
            doAction(pond, gameCardDeck, actionCardDeck, scanner);
        }
    }
}

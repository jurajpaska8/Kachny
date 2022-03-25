package models.abstractions.interfaces;

import exceptions.EmptyDeckException;
import models.abstractions.Card;

public interface ICardDeck
{
    <T extends Card> T popCard() throws EmptyDeckException;

    void shuffle();
}

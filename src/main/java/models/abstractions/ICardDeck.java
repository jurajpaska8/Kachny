package models.abstractions;

import exceptions.EmptyDeckException;

public interface ICardDeck
{
    <T extends Card> T popCard() throws EmptyDeckException;

    void shuffle();
}

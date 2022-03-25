package models;

import exceptions.EmptyDeckException;
import exceptions.FieldAlreadyAimedException;
import exceptions.FieldNotAimedException;

import java.util.Arrays;

public class Pond
{
    public static final int POND_SIZE = 6; // TODO outside

    private Field[] fieldsInPond;

    public Pond()
    {
        this.fieldsInPond = new Field[POND_SIZE];
        for(var i = 0; i < POND_SIZE; i++)
        {
            this.fieldsInPond[i] = new Field();
        }
    }

    public void printPond()
    {
        System.out.println("***** POND *****");
        for(int i = 0; i < POND_SIZE; i++)
        {
            System.out.println("Idx: '" + i + "' .Is aimed: " + fieldsInPond[i].isAimed() + ": " + fieldsInPond[i].getGameCard());
        }
        System.out.println("****************");
    }

    public void initPond(GameCardDeck gameCardDeck)
    {
        try
        {
            for(var i = 0; i < POND_SIZE; i++)
            {
                fieldsInPond[i].setGameCard(gameCardDeck.popCard());
            }
        }
        catch(EmptyDeckException e)
        {
            System.err.println("Fatal error, Pond is not able to initialize. Message:" + e.getMessage());
        }
    }

    public boolean isAllFieldsAimed()
    {
        return Arrays
                .stream(fieldsInPond)
                .allMatch(Field::isAimed);
    }

    public boolean isAllFieldsNotAimed()
    {
        return Arrays
                .stream(fieldsInPond)
                .noneMatch(Field::isAimed);
    }

    public void aimOnField(int idx) throws IndexOutOfBoundsException, FieldAlreadyAimedException
    {
        if(idx < 0 || idx >= POND_SIZE)
        {
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of range. In field are indices from: [0," + (POND_SIZE - 1) + "]");
        }
        fieldsInPond[idx].aimOnField();
    }

    public void shootOnField(int idx, GameCardDeck gameCardDeck) throws IndexOutOfBoundsException, FieldNotAimedException
    {
        if(idx < 0 || idx >= POND_SIZE)
        {
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of range. In field are indices from: [0," + (POND_SIZE - 1) + "]");
        }
        if(fieldsInPond[idx].shootOnField())
        {
            moveCardsToLeft(idx, gameCardDeck);
        }
    }

    public void useWildBill(int idx, GameCardDeck gameCardDeck) throws IndexOutOfBoundsException
    {
        if(idx < 0 || idx >= POND_SIZE)
        {
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of range. In field are indices from: [0," + (POND_SIZE - 1) + "]");
        }
        if(fieldsInPond[idx].useWildBill())
        {
            moveCardsToLeft(idx, gameCardDeck);
        }
    }

    private void moveCardsToLeft(int idx, GameCardDeck gameCardDeck)
    {
        try
        {
            for(int i = idx; i < POND_SIZE - 1; i++)
            {
                fieldsInPond[i].setGameCard(fieldsInPond[i + 1].getGameCard());
            }
            fieldsInPond[POND_SIZE - 1].setGameCard(gameCardDeck.popCard());
        }
        catch(EmptyDeckException e)
        {
            System.err.println("Deck is empty. It is not possible to add new card on the last position after move to left. Message:" + e.getMessage());
        }
    }

    public boolean isAimed(int idx) throws IndexOutOfBoundsException
    {
        if(idx < 0 || idx >= POND_SIZE)
        {
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of range. In field are indices from: [0," + (POND_SIZE - 1) + "]");
        }
        return fieldsInPond[idx].isAimed();
    }
}

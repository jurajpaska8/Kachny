package models;

import exceptions.FieldAlreadyAimedException;
import exceptions.FieldNotAimedException;
import models.abstractions.GameCard;

public class Field
{
    private GameCard gameCard;
    private boolean isAimed = false;

    public GameCard getGameCard()
    {
        return gameCard;
    }

    public void setGameCard(GameCard gameCard)
    {
        this.gameCard = gameCard;
    }

    public boolean isAimed()
    {
        return isAimed;
    }

    public void aimOnField() throws FieldAlreadyAimedException
    {
        if(isAimed)
        {
            throw new FieldAlreadyAimedException("Field is already aimed");
        }
        isAimed = true;
    }

    public boolean shootOnField() throws FieldNotAimedException
    {
        if(!isAimed)
        {
            throw new FieldNotAimedException("Field is not aimed");
        }
        isAimed = false;
        return gameCard.absorbShoot();
    }
}

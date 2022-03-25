package models.gameCards;

import models.abstractions.GameCard;

public class WaterCard extends GameCard
{
    private static final int WATER_COUNT = 5;

    @Override
    public String toString()
    {
        return "Water";
    }
    private boolean moveAfterAbsorbingShoot()
    {
        return false;
    }
    @Override
    public boolean absorbShoot()
    {
        System.out.println("You hit water.");
        return moveAfterAbsorbingShoot();
    }
}

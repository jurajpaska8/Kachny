package cards.gameCards;

import models.abstractions.GameCard;

public class WaterCard extends GameCard
{
    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
    }

    @Override
    protected boolean moveAfterAbsorbingShoot()
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

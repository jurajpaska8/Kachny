package models.abstractions;

public abstract class GameCard extends Card
{
    public static String CARD_DESC = "This is default game card description";

    protected boolean moveAfterAbsorbingShoot()
    {
        return true;
    }

    public abstract boolean absorbShoot();
}

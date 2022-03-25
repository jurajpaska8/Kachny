package models.abstractions;

public abstract class GameCard extends Card
{
    public static String CARD_DESC = "This is default game card description";

    public abstract boolean absorbShoot();
}

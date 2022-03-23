package models.abstractions;

public abstract class Card
{
    // description belongs to class, therefore is static
    public static final String CARD_DESC = "This is default card description";

    public String getCardDescription()
    {
        return this.getClass().getSimpleName() + ": " + CARD_DESC;
    }
}

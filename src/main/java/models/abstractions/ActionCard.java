package models.abstractions;

import models.Pond;

public abstract class ActionCard extends Card
{
    // description belongs to class, therefore is static
    public static final String CARD_DESC = "This is default action card description";

    public abstract void applyCard(Pond pond, int fieldIdx);
}

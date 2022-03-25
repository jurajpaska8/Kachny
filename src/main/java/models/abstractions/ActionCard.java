package models.abstractions;

import exceptions.NotPlayableCardException;
import models.Pond;

import java.util.Scanner;

public abstract class ActionCard extends Card
{
    // description belongs to class, therefore is static
    public static final String CARD_DESC = "This is default action card description";

    public abstract void doAction(Pond pond, Scanner scanner) throws NotPlayableCardException;
}

import models.Pond;
import models.abstractions.ActionCard;
import models.abstractions.Card;
import models.abstractions.GameCard;
import models.actionCards.shootingCards.ShootCard;
import models.actionCards.shootingCards.WildBillCard;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Toto je kachna");
        var wildBill = new WildBillCard();
        var shootCard = new ShootCard();

        System.out.println(Card.CARD_DESC);
        System.out.println(ActionCard.CARD_DESC);
        System.out.println(GameCard.CARD_DESC);
        System.out.println(wildBill.getCardDescription());
        System.out.println(shootCard.getCardDescription());

        Pond pond = new Pond();
        var fields = pond.getFieldsInPond();

    }
}

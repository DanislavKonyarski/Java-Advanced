package T3CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardRank cardRank = CardRank.valueOf(scanner.nextLine());
        CardSuit cardSuit = CardSuit.valueOf(scanner.nextLine());
        Cards cards = new Cards(cardRank,cardSuit);

        System.out.printf("Card name: %s of %s; Card power: %d",cards.getCardRank(),cards.getCardSuit(),cards.getPower());
    }
}

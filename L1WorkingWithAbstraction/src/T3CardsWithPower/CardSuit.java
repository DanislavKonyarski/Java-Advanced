package T3CardsWithPower;

public enum CardSuit {

    CLUBS(0),DIAMONDS(13),HEARTS(26),SPADES(39);
    private int cardSuit;

    CardSuit(int cardSuit) {
        this.cardSuit = cardSuit;
    }

    public int getCardSuit() {
        return cardSuit;
    }

}

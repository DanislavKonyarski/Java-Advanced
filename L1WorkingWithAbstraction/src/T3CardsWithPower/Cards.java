package T3CardsWithPower;

public class Cards {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Cards(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }
    public int getPower (){
        return getCardSuit().getCardSuit()+getCardRank().getCardRank();
    }
}

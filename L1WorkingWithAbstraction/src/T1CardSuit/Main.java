package T1CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (int i = 0; i < CardSuit.values().length; i++) {
//            Ordinal value: 0; Name value: CLUBS
//Ordinal value: 1; Name value: DIAMONDS
            System.out.println("Ordinal value: "+i+"; Name value: "+CardSuit.values()[i]);
        }
    }
}

package T2CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (int i = 0; i < CardRank.values().length; i++) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",i,CardRank.values()[i]);
        }
    }
}

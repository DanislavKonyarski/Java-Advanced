package SetsAndMapsAdvancedExercises;

import java.util.*;

public class T7HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> handsMap = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String name = input.split(":")[0];
            String cards = input.split(": ")[1];
            String[] card = cards.split(", ");
            handsMap.putIfAbsent(name, new HashSet<>());
            Collections.addAll(handsMap.get(name),card);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> entry : handsMap.entrySet()) {
            System.out.println(entry.getKey()+": "+result(entry.getValue()));
        }

    }

    private static Integer result(Set<String> card) {
        int sum = 0;
        for (String s : card){
            int power = 0;
            switch (s.substring(0,s.length()-1)) {
                case "1":
                    power = 1;
                    break;
                case "2":
                    power = 2;
                    break;
                case "3":
                    power = 3;
                    break;
                case "4":
                    power = 4;
                    break;
                case "5":
                    power = 5;
                    break;
                case "6":
                    power = 6;
                    break;
                case "7":
                    power = 7;
                    break;
                case "8":
                    power = 8;
                    break;
                case "9":
                    power = 9;
                    break;
                case "10":
                    power = 10;
                    break;
                case "J":
                    power = 11;
                    break;
                case "Q":
                    power = 12;
                    break;
                case "K":
                    power = 13;
                    break;
                case "A":
                    power = 14;
                    break;
            }
            int point = 0;
            switch (s.substring(s.length() - 1)) {
                case "S":
                    point = 4;
                    break;
                case "H":
                    point = 3;
                    break;
                case "D":
                    point = 2;
                    break;
                case "C":
                    point = 1;
                    break;
            }
            sum += point * power;
        }
        return sum;
    }
}

package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class T3VoinaNumbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstSet = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondSet = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        int count = 50;
        while (count-- > 0) {
            int firstCard = 0;
            for (Integer integer : firstSet) {
                firstCard = integer;
                break;
            }
            firstSet.remove(firstCard);
            int secondCard = 0;
            for (Integer integer : secondSet) {
                secondCard = integer;
                break;
            }
            secondSet.remove(secondCard);
            if (firstCard>secondCard){
                firstSet.add(firstCard);
                firstSet.add(secondCard);
            } else if (firstCard<secondCard) {
                secondSet.add(firstCard);
                secondSet.add(secondCard);
            }
            if (firstSet.isEmpty()||secondSet.isEmpty()){
                break;
            }
        }
        if (firstSet.size()>secondSet.size()){
            System.out.println("First player win!");
        } else if (firstSet.size()<secondSet.size()) {
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }
    }
}

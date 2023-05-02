package SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class T2SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] countSets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> firstSets = new LinkedHashSet<>();
        Set<Integer> secondSets = new LinkedHashSet<>();
        for (int i = 0; i < countSets[0]; i++) {
            firstSets.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < countSets[1]; i++) {
           secondSets.add(Integer.parseInt(scanner.nextLine()));
        }
        firstSets.retainAll(secondSets);
        System.out.println(String.join(" ",firstSets.toString()).replace("[","")
                .replace("]","").replace(",",""));
    }
}

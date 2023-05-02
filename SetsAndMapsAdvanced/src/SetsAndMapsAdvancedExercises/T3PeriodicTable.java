package SetsAndMapsAdvancedExercises;

import java.util.*;

public class T3PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countInput = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < countInput; i++) {
            String[] input = scanner.nextLine().split(" ");
            Collections.addAll(elements, input);
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}


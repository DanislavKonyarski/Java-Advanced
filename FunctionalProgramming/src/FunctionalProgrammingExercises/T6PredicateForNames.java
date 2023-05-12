package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T6PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countSymbol = Integer.parseInt(scanner.nextLine());
        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        input.stream().filter(e -> e.length()<=countSymbol).forEach(System.out::println);
    }
}

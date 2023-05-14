package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class T8CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] input =  Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Comparator<Integer> comparator = (e, b) -> {
            if (e % 2 != 0 &&b % 2 == 0 ){
                return 1;
            } else if (e % 2 == 0 &&b % 2 != 0 ){
                return -1;
            }
            return e.compareTo(b);
        };
        Arrays.sort(input, comparator);
        Arrays.stream(input).forEach(e -> System.out.print(e + " "));
    }
}

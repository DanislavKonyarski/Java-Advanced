package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T5ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int numberForDivisible = Integer.parseInt(scanner.nextLine());
        Collections.reverse(input);
        input.stream().filter(e -> e % numberForDivisible != 0).forEach(e -> System.out.print(e + " "));
    }
}

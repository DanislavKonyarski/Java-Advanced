package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;

public class T3CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int minNumber = Arrays.stream(input).min().orElseThrow();
        System.out.println(minNumber);
    }
}

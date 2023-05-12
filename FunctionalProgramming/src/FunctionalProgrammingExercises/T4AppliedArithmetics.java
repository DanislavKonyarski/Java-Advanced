package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T4AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    input = input.stream().map(e -> e + 1).collect(Collectors.toList());
                    break;
                case "multiply":
                    input = input.stream().map(e -> e * 2).collect(Collectors.toList());
                    break;
                case "subtract":
                    input = input.stream().map(e -> e - 1).collect(Collectors.toList());
                    break;
                case "print":
                    input.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}

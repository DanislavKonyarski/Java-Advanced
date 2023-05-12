package FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class T5FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countInput = Integer.parseInt(scanner.nextLine());
        List<String> input = new ArrayList<>();
        for (int i = 0; i < countInput; i++) {
            input.add(scanner.nextLine());
        }
        String condition = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        switch (condition) {
            case "younger":
                input = input.stream().filter(e -> Integer.parseInt(e.split(",\\s+")[1])<=ageFilter)
                        .collect(Collectors.toList());
                break;
            case "older":
                input = input.stream().filter(e -> Integer.parseInt(e.split(",\\s+")[1])>=ageFilter)
                        .collect(Collectors.toList());
                break;
        }

        switch (format) {
            case "name":
                input.forEach(s -> System.out.println(s.split(",\\s+")[0]));
                break;
            case "age":
                input.forEach(s -> System.out.println(s.split(",\\s+")[1]));
                break;
            case "name age":
                input.forEach(s -> System.out.printf("%s - %s%n", s.split(",\\s+")[0], s.split(",\\s+")[1]));
                break;
        }
    }
}

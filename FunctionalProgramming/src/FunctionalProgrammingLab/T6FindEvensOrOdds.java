package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class T6FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.next().split("\\s+")[0]);
        int end = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        int[] input = IntStream.rangeClosed(start, end).toArray();
        String oddEven = scanner.nextLine();

        if (oddEven.equals("odd")) {
            Arrays.stream(input).filter(e -> e % 2 != 0).forEach(e -> System.out.print(e + " "));
        } else if (oddEven.equals("even")) {
            Arrays.stream(input).filter(e -> e % 2 == 0).forEach(e -> System.out.print(e + " "));
        }
    }
}

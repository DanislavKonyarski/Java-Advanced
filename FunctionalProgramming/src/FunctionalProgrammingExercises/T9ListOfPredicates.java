package FunctionalProgrammingExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class T9ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int[] numberForDivisible = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            numbers.add(i);
        }
        numbers.stream().filter(e -> {
            boolean flag = false;
            for (int i = 0; i < numberForDivisible.length; i++) {
                if (e % numberForDivisible[i] ==0) {
                    flag =  true;
                }else {
                    flag = false;
                    break;
                }
            }
            return flag;
        }).forEach(e -> System.out.print(e + " "));
    }
}

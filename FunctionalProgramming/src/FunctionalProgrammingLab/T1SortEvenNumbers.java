package FunctionalProgrammingLab;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class T1SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).filter(e -> e%2==0)
                .collect(Collectors.toList());
        getPrintln(list);
        Collections.sort(list);
        getPrintln(list);

    }

    private static void getPrintln(List<Integer> list) {
        System.out.println(String.join(", ", list.toString()).replace("[","")
                .replace("]",""));
    }
}

package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T7FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> function = e ->{
         int minNumber = Integer.MAX_VALUE;
            for (Integer item : e) {
                if (item<minNumber){
                    minNumber = item;
                }
            }
         return minNumber;};
        int index = 0;
        for (int i = 0; i < input.size(); i++) {
            if (function.apply(input)==input.get(i)){
                index=i;
            }
        }
        System.out.println(index);
    }
}

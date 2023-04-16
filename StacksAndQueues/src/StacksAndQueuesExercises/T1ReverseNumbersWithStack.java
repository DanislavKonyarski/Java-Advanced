package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class T1ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> reversNumber = new ArrayDeque<>();
        for (int number : numbers) {
            reversNumber.push(number);
        }
        for (Integer integer : reversNumber) {
            System.out.print(integer+" ");
        }
    }
}

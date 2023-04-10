package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T2SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Deque<Integer> sumStack = new ArrayDeque<>();
        sumStack.push(Integer.parseInt(input[0]));
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("-")) {
                int sum = sumStack.pop() - Integer.parseInt(input[i + 1]);
                sumStack.push(sum);
            } else if (input[i].equals("+")) {
                int sum = sumStack.pop() + Integer.parseInt(input[i + 1]);
                sumStack.push(sum);

            }
        }
        System.out.println(sumStack.peek());
    }
}

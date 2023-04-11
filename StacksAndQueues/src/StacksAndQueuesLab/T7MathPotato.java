package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class T7MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] namesArr = scanner.nextLine().split("\\s+");
        int number = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> namesDeq = new PriorityQueue<>();

        for (String name : namesArr) {
            namesDeq.offer(name);
        }
        int currentNumber = 1;
        while (namesDeq.size() != 1) {
            boolean flag = true;
            if (currentNumber == 1) {
                System.out.println("Removed " + namesDeq.poll());
                currentNumber++;
                continue;

            }
            for (int i = 2; i < currentNumber; i++) {
                if (currentNumber % i == 0) {
                    System.out.println("Removed " + namesDeq.poll());
                    flag = false;
                    break;
                }
            }if (flag) {
                System.out.println("Prime " + namesDeq.peek());
            }
            currentNumber++;
        }
        System.out.println("Last is " + namesDeq.poll());
    }

}

package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T6HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] namesArr = scanner.nextLine().split("\\s+");
        int number = Integer.parseInt(scanner.nextLine());
        Deque<String> namesDeq = new ArrayDeque<>();
        for (String name : namesArr) {
            namesDeq.offer(name);
        }
        while (namesDeq.size() != 1) {
            for (int i = 0; i < number - 1; i++) {
                String name = namesDeq.poll();
                namesDeq.offer(name);
            }
            System.out.println("Removed " + namesDeq.poll());
        }
        System.out.println("Last is " + namesDeq.poll());
    }
}

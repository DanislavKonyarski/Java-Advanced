package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T3DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        Deque<Long> binaryDeq = new ArrayDeque<>();
        if (input==0){
            System.out.println(0);
        }
        while (input!=0){
            binaryDeq.push(input % 2);
            input = input / 2;
        }
        for (Long item : binaryDeq) {
            System.out.print(binaryDeq.pop());
        }
    }
}

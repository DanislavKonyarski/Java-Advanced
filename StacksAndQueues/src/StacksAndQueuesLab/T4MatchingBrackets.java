package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T4MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<Integer> index = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)=='('){
                index.push(i);
            } else if (input.charAt(i)==')') {
                int startIndex = index.pop();
                String item = input.substring(startIndex,i+1);
                System.out.println(item);
            }

        }
    }
}

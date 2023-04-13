import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T5BalancedParentheses75From100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            char[] input = scanner.next().toCharArray();
            Deque<Character> parenthesisLeftSide = new ArrayDeque<>();
            Deque<Character> parenthesisRightSide = new ArrayDeque<>();
            boolean flag = false;
            if (input.length  % 2 == 1) {
                System.out.println("NO");
            } else {
                for (int i = 0; i < input.length / 2; i++) {
                    parenthesisLeftSide.push(input[i]);
                }
                for (int i = input.length / 2; i < input.length; i++) {
                    parenthesisRightSide.offer(input[i]);
                }
                int size = parenthesisRightSide.size();
                for (int i = 0; i < size; i++) {
                    char liftSide = parenthesisLeftSide.pop();
                    char rightSide = parenthesisRightSide.poll();
                    if (liftSide == '(' && rightSide == ')'
                            || liftSide == '[' && rightSide == ']' ||
                            liftSide == '{' && rightSide == '}') {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

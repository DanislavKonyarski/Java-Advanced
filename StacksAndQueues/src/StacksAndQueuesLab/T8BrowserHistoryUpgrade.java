package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T8BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<String> back = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();
        while (!input.equals("Home")){
            if (input.equals("forward")){
                if (forward.size()==0){
                    System.out.println("no next URLs");
                }else {
                    String forwardUrl = forward.pop();
                    back.push(forwardUrl);
                    System.out.println(back.peek());
                }
            } else if (input.equals("back")) {
                if (back.size()<=1){
                    System.out.println("no previous URLs");
                }else {
                String backUrl = back.pop();
                forward.push(backUrl);
                System.out.println(back.peek());
                }
            }else {
                back.push(input);
                System.out.println(back.peek());
                forward.clear();
            }
            input = scanner.nextLine();
        }
    }
}

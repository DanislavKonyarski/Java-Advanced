package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T1BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<String> urlDeq = new ArrayDeque<>();
        while (!input.equals("Home")){
            if (!input.equals("back")){
                urlDeq.push(input);
                System.out.println(urlDeq.peek());
            }else {
                if (urlDeq.size()>1){
                    urlDeq.pop();
                System.out.println(urlDeq.peek());
                }else {
                    System.out.println("no previous URLs");
                }
            }
            input = scanner.nextLine();
        }
    }
}

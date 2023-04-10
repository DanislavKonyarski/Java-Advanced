package StacksAndQueuesLab;

import javax.security.sasl.SaslClient;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T5PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<String> printFilesDeq = new ArrayDeque<>();
        while (!input.equals("print")){
            if (!input.equals("cancel")){
                printFilesDeq.offer(input);
            }else {
                if (printFilesDeq.size()==0){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled "+printFilesDeq.poll());
                }
            }
            input = scanner.nextLine();
        }
        for (String s : printFilesDeq) {
            System.out.println(printFilesDeq.poll());
        }
    }
}

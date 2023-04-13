import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T7SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCommand = Integer.parseInt(scanner.nextLine());
        Deque<String> stringStack = new ArrayDeque<>();
        stringStack.push("");
        for (int i = 0; i < countCommand; i++) {
            String input = scanner.nextLine();
            String string = stringStack.peek();
            int command = Integer.parseInt(input.split("\\s+")[0]);
            if (command == 1) {
                String textForAppend = input.split("\\s+")[1];
                string += textForAppend;
                stringStack.push(string);
            } else if (command == 2) {
                int countElements = Integer.parseInt(input.split("\\s+")[1]);
                string = string.substring(0, string.length() - countElements);
                stringStack.push(string);
            } else if (command == 3) {
                int index = Integer.parseInt(input.split("\\s+")[1]) - 1;
                System.out.println(string.charAt(index));
            } else if (command == 4) {
                stringStack.pop();
            }
        }
    }
}

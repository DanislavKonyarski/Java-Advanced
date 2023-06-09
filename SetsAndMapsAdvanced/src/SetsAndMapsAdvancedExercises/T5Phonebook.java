package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T5Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {
            phonebook.put(input.split("-")[0], input.split("-")[1]);
            input = scanner.nextLine();
        }
        input=scanner.nextLine();
        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            }else {
                System.out.println("Contact "+input+" does not exist.");
            }
            input = scanner.nextLine();
        }
    }
}

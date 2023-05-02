package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T6FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> emailMap = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) { //!!!
                emailMap.put(name, email);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : emailMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}

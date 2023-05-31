package GenericsExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String command = input.split("\\s+")[0];
            switch (command){
                case "Add":
                    customList.add(input.split(" ")[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(input.split(" ")[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(input.split(" ")[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(input.split(" ")[1]),Integer.parseInt(input.split(" ")[2]));
                    break;
                case "Greater":
                    System.out.println(customList.greater(input.split(" ")[1]));
                    break;
                case "Max":
                    System.out.println(customList.max());
                    break;
                case "Min":
                    System.out.println(customList.min());
                    break;
                case "Print":
                    System.out.println(customList.toString());
                    break;
                case "Sort":
                    customList.sort();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
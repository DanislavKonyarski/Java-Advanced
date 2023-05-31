package GenericsExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countInput = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        for (int i = 0; i < countInput; i++) {
            Integer input = Integer.parseInt(scanner.nextLine());
            box.add(input);
        }
        System.out.println(box);
    }
}

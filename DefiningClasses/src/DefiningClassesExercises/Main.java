package DefiningClassesExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPerson = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < countPerson; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            persons.add(person);
        }
        persons.stream().filter(e -> e.getAge()>30).sorted((first, second) -> first.getName().compareTo(second.getName()))
                .forEach(System.out::println);
    }
}

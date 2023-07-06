package T3BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        while (!"End".equals(input)){
            switch (input.split("\\s+")[0]){
                case "Citizen":
                    String nameCitizen = input.split("\\s+")[1];
                    int ageCitizen = Integer.parseInt(input.split("\\s+")[2]);
                    String idCitizen = input.split("\\s+")[3];
                    String birthDateCitizen = input.split("\\s+")[4];
                    Citizen citizen = new Citizen(nameCitizen,ageCitizen,idCitizen,birthDateCitizen);
                    citizens.add(citizen);
                    break;
                case "Pet":
                    String namePet = input.split("\\s+")[1];
                    String birthDatePet = input.split("\\s+")[2];
                    Pet pet = new Pet(namePet,birthDatePet);
                    pets.add(pet);
                    break;
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        String finalInput = input;
        citizens.stream().filter(e -> e.getBirthDate().contains(finalInput)).forEach(e -> System.out.println(e.getBirthDate()));
        pets.stream().filter(e -> e.getBirthDate().contains(finalInput)).forEach(e -> System.out.println(e.getBirthDate()));
    }
}

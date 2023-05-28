package DefiningClassesExercises;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Person> personMap = new HashMap<>();
        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            String namePerson = info[0];
            String insertInfo = info[1];
            switch (insertInfo) {
                case "company":
                    String companyName = info[2];
                    String department = info[3];
                    double salary = Double.parseDouble(info[4]);
                    personMap.putIfAbsent(namePerson, new Person(namePerson));
                    Company currentCompany = new Company();
                    currentCompany.setName(companyName);
                    currentCompany.setDepartment(department);
                    currentCompany.setSalary(salary);
                    personMap.get(namePerson).setCompany(currentCompany);
                    break;
                case "pokemon":
                    String pokemonName = info[2];
                    String pokemonType = info[3];
                    Pokemon currentPokemon = new Pokemon();
                    currentPokemon.setName(pokemonName);
                    currentPokemon.setType(pokemonType);
                    personMap.putIfAbsent(namePerson, new Person(namePerson));
                    personMap.get(namePerson).addPokemon(currentPokemon);
                    break;
                case "parents":
                    String parentsName = info[2];
                    String parentsBirthDay = info[3];
                    Parents currentParents = new Parents();
                    currentParents.setName(parentsName);
                    currentParents.setBirthDay(parentsBirthDay);
                    personMap.putIfAbsent(namePerson, new Person(namePerson));
                    personMap.get(namePerson).addParents(currentParents);
                    break;
                case "children":
                    String childrenName = info[2];
                    String childrenBirthDay = info[3];
                    Children currentChildren = new Children();
                    currentChildren.setName(childrenName);
                    currentChildren.setBirthDay(childrenBirthDay);
                    personMap.putIfAbsent(namePerson, new Person(namePerson));
                    personMap.get(namePerson).addChildren(currentChildren);
                    break;
                case "car":
                    String carModel = info[2];
                    int carSpeed = Integer.parseInt(info[3]);
                    Car currentCar = new Car();
                    currentCar.setModel(carModel);
                    currentCar.setSpeed(carSpeed);
                    personMap.putIfAbsent(namePerson, new Person(namePerson));
                    personMap.get(namePerson).setCar(currentCar);
                    break;
            }
            input = scanner.nextLine();
        }
        String printPerson = scanner.nextLine();
        System.out.println(printPerson);
        System.out.println("Company:");
        if (personMap.get(printPerson).getCompany().getName() != null) {
            System.out.println(personMap.get(printPerson).getCompany().toString());
        }

        System.out.println("Car:");
        if (personMap.get(printPerson).getCar().getModel() != null) {
            System.out.println(personMap.get(printPerson).getCar().toString());
        }

        System.out.println("Pokemon:");
        if (personMap.get(printPerson).getPokemonList().size()!=0){
            personMap.get(printPerson).getPokemonList().forEach(System.out::println);
        }

        System.out.println("Parents:");
        if (personMap.get(printPerson).getParentsList().size()!=0){
            personMap.get(printPerson).getParentsList().forEach(System.out::println);
        }

        System.out.println("Children:");
        if (personMap.get(printPerson).getChildrenList().size()!=0){
            personMap.get(printPerson).getChildrenList().forEach(System.out::println);
        }
    }
}

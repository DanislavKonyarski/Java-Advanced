package T6Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"Beast!".equals(input)) {
            String animal = input;
            String[] animalType = scanner.nextLine().split("\\s+");
            try {
                switch (animal) {
                    case "Dog":
                        Dog dog = new Dog(animalType[0], Integer.parseInt(animalType[1]), animalType[2]);
                        System.out.println(dog);
                        break;
                    case "Cat":
                        Cat cat = new Cat(animalType[0], Integer.parseInt(animalType[1]), animalType[2]);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(animalType[0], Integer.parseInt(animalType[1]), animalType[2]);
                        System.out.println(frog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(animalType[0], Integer.parseInt(animalType[1]));
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(animalType[0], Integer.parseInt(animalType[1]));
                        System.out.println(tomcat);
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
    }
}

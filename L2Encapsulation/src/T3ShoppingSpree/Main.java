package T3ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputPersons = scanner.nextLine().split(";");
        String[] inputProducts = scanner.nextLine().split(";");
        List<Person> personsList = new ArrayList<>();
        List<Product> productsList = new ArrayList<>();
        try {
            insertPersonsList(inputPersons, personsList);
            insertProductList(inputProducts, productsList);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String buyer = command.split("\\s+")[0];
            String productName = command.split("\\s+")[1];

            try {
                personsList.stream().filter(e -> e.getName().equals(buyer)).forEach(e ->
                        e.buyProduct(productsList.stream().filter(i -> i.getName().equals(productName)).findFirst().get()));
                System.out.println(buyer+" bought "+productName);
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }

            command = scanner.nextLine();
        }
        for (Person person : personsList) {
            if (person.getSizeProduct()==0) {
                System.out.println(person.getName()+" – Nothing bought");
            }else {
                System.out.println(person);

            }
        }
    }

    private static void insertProductList(String[] inputProducts, List<Product> productsList) {
        for (String products : inputProducts) {
            String[] currentProductArr = products.split("=");
            String productName = currentProductArr[0];
            double cost = Double.parseDouble(currentProductArr[1]);
            Product product = new Product(productName, cost);
            productsList.add(product);
        }
    }

    private static void insertPersonsList(String[] inputPersons, List<Person> personsList) {
        for (String persons : inputPersons) {
            String[] currentPersonArr = persons.split("=");
            String personName = currentPersonArr[0];
            double money = Double.parseDouble(currentPersonArr[1]);
            Person person = new Person(personName, money);
            personsList.add(person);
        }
    }
}

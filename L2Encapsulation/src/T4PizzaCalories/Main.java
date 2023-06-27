package T4PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputPizza = scanner.nextLine().split(" ");
        Pizza pizza;
        try {
            pizza = new Pizza(inputPizza[1], Integer.parseInt(inputPizza[2]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        String[] inputDough = scanner.nextLine().split("\\s+");
        Dough dough;
        try {
            dough = new Dough(inputDough[1], inputDough[2], Integer.parseInt(inputDough[3]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        pizza.setDough(dough);
        String[] topping = scanner.nextLine().split("\\s+");
        for (int i = 0; i < Integer.parseInt(inputPizza[2]); i++) {
            Topping currentTopping;
            try {
                currentTopping = new Topping(topping[1], Integer.parseInt(topping[2]));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            pizza.addTopping(currentTopping);

            topping = scanner.nextLine().split("\\s+");
        }
        System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());
    }
}

package DefiningClassesExercises;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countEngin = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        for (int i = 0; i < countEngin; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String modelEngin = input[0];
            int power = Integer.parseInt(input[1]);
            Engine engine = new Engine(modelEngin, power);
            if (input.length == 3) {
                if (Character.isDigit(input[2].charAt(0))) {
                    int displacement = Integer.parseInt(input[2]);
                    engine.setDisplacement(displacement);
                } else {
                    String efficiency = input[2];
                    engine.setEfficiency(efficiency);
                }
            } else if (input.length == 4) {
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                engine.setEfficiency(efficiency);
                engine.setDisplacement(displacement);
            }
            engineList.add(engine);
        }
        int countCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < countCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String modelCar = input[0];
            String engine = input[1];
            int enginPosition = 0;
            for (int j = 0; j < engineList.size(); j++) {
                if (engineList.get(j).getModelEngine().equals(engine)){
                    enginPosition = j;
                }
            }
            Car car = new Car(modelCar, engineList.get(enginPosition));
            if (input.length == 3) {
                if (Character.isDigit(input[2].charAt(0))) {
                    int weight = Integer.parseInt(input[2]);
                    car.setWeight(weight);
                } else {
                    String color = input[2];
                    car.setColor(color);
                }
            } else if (input.length == 4) {
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                car.setWeight(weight);
                car.setColor(color);
            }
            carList.add(car);
        }
        carList.forEach(System.out::println);
    }
}

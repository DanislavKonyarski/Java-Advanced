package DefiningClassesExercises;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCars = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();

        for (int i = 0; i < countCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int enginSpeed = Integer.parseInt(input[1]);
            int enginPower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Engine engine = new Engine(enginSpeed,enginPower);
            Cargo cargo = new Cargo(cargoWeight,cargoType);
            Tire tire = new Tire(tire1Pressure,tire1Age,tire2Pressure,tire2Age,tire3Pressure,tire3Age,tire4Pressure,tire4Age);
            Car car = new Car(model,engine,cargo,tire);
            carsList.add(car);
        }
        String command = scanner.nextLine();
        if (command.equals("fragile")){
        carsList.stream().filter(e -> e.getCargo().getCargoType().equals(command))
                .filter(e -> e.getTire().getTire1Pressure()<1||e.getTire().getTire2Pressure()<1
                ||e.getTire().getTire3Pressure()<1||e.getTire().getTire4Pressure()<1)
                .forEach(e -> System.out.println(e.getModelCar()));
        } else if (command.equals("flamable")) {
            carsList.stream().filter(e -> e.getCargo().getCargoType().equals(command)&&
                            e.getEngine().getEnginePower()>250)
                    .forEach(e -> System.out.println(e.getModelCar()));
        }
    }
}

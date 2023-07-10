package T1Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicles> vehiclesMap = new LinkedHashMap<>();
        String[] inputCar = scanner.nextLine().split("\\s+");
        double fuelQuantityCar = Double.parseDouble(inputCar[1]);
        double litersPerKmCar = Double.parseDouble(inputCar[2]);
        Car car = new Car(fuelQuantityCar, litersPerKmCar);
        vehiclesMap.put(inputCar[0], car);

        String[] inputTruck = scanner.nextLine().split("\\s+");
        double fuelQuantityTruck = Double.parseDouble(inputTruck[1]);
        double litersPerKmTruck = Double.parseDouble(inputTruck[2]);
        Truck truck = new Truck(fuelQuantityTruck, litersPerKmTruck);
        vehiclesMap.put(inputTruck[0], truck);

        int countCommand = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countCommand; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];
            String typeVehicles = commands[1];
            double fuelOrDistans = Double.parseDouble(commands[2]);

            if ("Drive".equals(command)) {
                double distans = Double.parseDouble(commands[2]);
                System.out.println(vehiclesMap.get(typeVehicles).drive(distans));
            } else if ("Refuel".equals(command)) {
                double fuel = Double.parseDouble(commands[2]);
                vehiclesMap.get(typeVehicles).refuel(fuel);
            }
        }
        for (Map.Entry<String, Vehicles> entry : vehiclesMap.entrySet()) {
            System.out.printf("Car: %.2f%n",entry.getValue().getFuelQuantity());
        }
    }
}

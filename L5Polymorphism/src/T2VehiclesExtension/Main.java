package T2VehiclesExtension;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Transport> transportMap = new LinkedHashMap<>();
        
        try {
            String[] inputCar = scanner.nextLine().split("\\s+");
            double fuelQuantityCar = Double.parseDouble(inputCar[1]);
            double litersPerKmCar = Double.parseDouble(inputCar[2]);
            double tankCapacityCar = Double.parseDouble(inputCar[3]);

            Car car = new Car(fuelQuantityCar, litersPerKmCar, tankCapacityCar);
            transportMap.put(inputCar[0], car);

            String[] inputTruck = scanner.nextLine().split("\\s+");
            double fuelQuantityTruck = Double.parseDouble(inputTruck[1]);
            double litersPerKmTruck = Double.parseDouble(inputTruck[2]);
            double tankCapacityTruck = Double.parseDouble(inputTruck[3]);

            Truck truck = new Truck(fuelQuantityTruck, litersPerKmTruck, tankCapacityTruck);
            transportMap.put(inputTruck[0], truck);

            String[] inputBus = scanner.nextLine().split("\\s+");
            double fuelQuantityBus = Double.parseDouble(inputBus[1]);
            double litersPerKmBus = Double.parseDouble(inputBus[2]);
            double tankCapacityBus = Double.parseDouble(inputBus[3]);

            Bus bus = new Bus(fuelQuantityBus, litersPerKmBus, tankCapacityBus);
            transportMap.put(inputBus[0], bus);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
        int countCommand = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countCommand; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];
            String typeVehicles = commands[1];

            if ("Drive".equals(command)) {
                double distans = Double.parseDouble(commands[2]);
                System.out.println(transportMap.get(typeVehicles).drive(distans));
            } else if ("Refuel".equals(command)) {
                try {
                double fuel = Double.parseDouble(commands[2]);
                transportMap.get(typeVehicles).refuel(fuel);
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            } else if ("DriveEmpty".equals(command)) {
                double distans = Double.parseDouble(commands[2]);
                System.out.println(((Bus) transportMap.get("Bus")).DriveEmpty(distans));
            }
        }
        for (Map.Entry<String, Transport> entry : transportMap.entrySet()) {
            System.out.printf("%s: %.2f%n",entry.getKey(),entry.getValue().getFuelQuantity());
        }
    }
}

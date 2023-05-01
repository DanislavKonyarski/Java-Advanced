package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class T1ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> parkingLot = new LinkedHashSet<>();
        while (!input.equals("END")){
            String command = input.split(",\\s+")[0];
            String carNumber = input.split(",\\s+")[1];
            if (command.equals("IN")){
                parkingLot.add(carNumber);
            } else if (command.equals("OUT")) {
                parkingLot.remove(carNumber);
            }
            input = scanner.nextLine();
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String carNumber : parkingLot) {
                System.out.println(carNumber);
            }
        }
    }
}

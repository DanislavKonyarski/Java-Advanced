package DefiningClassesLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countInput = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < countInput; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length==1){
            cars.add(new Car(input[0]));
            }else{
                cars.add(new Car(input[0],input[1],Integer.parseInt(input[2])));
            }

        }
        cars.forEach(e -> System.out.println(e.carInfo()));
    }
}
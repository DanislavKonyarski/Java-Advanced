package T4TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lights = scanner.nextLine().split(" ");
        int count = Integer.parseInt(scanner.nextLine());
        List<TrafficLights> lightsList = new ArrayList<>();
        Arrays.stream(lights).forEach(e-> lightsList.add(new TrafficLights(Lights.valueOf(e))));
        for (int i = 0; i < count; i++) {
            lightsList.stream().forEach(e-> System.out.print(e.nextLight()+" "));
            System.out.println();
        }
    }
}

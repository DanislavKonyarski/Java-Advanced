package SetsAndMapsAdvancedLab;

import java.util.*;

public class T7CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countInput = Integer.parseInt(scanner.nextLine());
        Map<String , Map<String, List<String>>> productMap = new LinkedHashMap<>();
        for (int i = 0; i < countInput; i++) {
            String input = scanner.nextLine();
            String continents = input.split("\\s+")[0];
            String countries = input.split("\\s+")[1];
            String cities = input.split("\\s+")[2];

            productMap.putIfAbsent(continents, new LinkedHashMap<>());
            productMap.get(continents).putIfAbsent(countries, new ArrayList<>());
            productMap.get(continents).get(countries).add(cities);

        }
        for (Map.Entry<String, Map<String, List<String>>> entry : productMap.entrySet()) {
            System.out.println(entry.getKey()+":");
            for (Map.Entry<String, List<String>> ent : productMap.get(entry.getKey()).entrySet()) {
                System.out.printf("%s -> %s%n",ent.getKey(),String.join(", ",ent.getValue()));
            }
        }
    }
}


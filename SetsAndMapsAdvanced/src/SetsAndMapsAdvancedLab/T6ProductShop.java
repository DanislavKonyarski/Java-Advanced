package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T6ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String , Map<String, Double>> productMap = new TreeMap<>();
        while (!input.equals("Revision")){
            String magazine = input.split(",\\s+")[0];
            String product = input.split(",\\s+")[1];
            double price = Double.parseDouble(input.split(",\\s+")[2]);

            productMap.putIfAbsent(magazine, new LinkedHashMap<>());
            productMap.get(magazine).putIfAbsent(product, price);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> entry : productMap.entrySet()) {
            System.out.println(entry.getKey()+"->");
            for (Map.Entry<String, Double> ent : productMap.get(entry.getKey()).entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",ent.getKey(),ent.getValue());
            }

        }

    }
}

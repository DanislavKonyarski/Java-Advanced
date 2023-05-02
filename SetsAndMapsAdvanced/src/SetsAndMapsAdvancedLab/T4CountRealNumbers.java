package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T4CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < inputArr.length; i++) {
            countMap.putIfAbsent(inputArr[i], 0);
            countMap.put(inputArr[i], countMap.get(inputArr[i]) + 1);
        }
        for (Map.Entry<Double, Integer> entry : countMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}

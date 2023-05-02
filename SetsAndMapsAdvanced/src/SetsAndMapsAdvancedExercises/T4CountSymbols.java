package SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class T4CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        Map<Character,Integer> countSymbolMap = new TreeMap<>();
        for (int i = 0; i < input.length; i++) {
            countSymbolMap.putIfAbsent(input[i],0);
            countSymbolMap.put(input[i],countSymbolMap.get(input[i])+1);
        }
        for (Map.Entry<Character, Integer> entry : countSymbolMap.entrySet()) {
            System.out.printf("%s: %d time/s%n",entry.getKey(),entry.getValue());
        }
    }
}
